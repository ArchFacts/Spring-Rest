package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Endereco;
import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.enums.Role;
import Facts.Arch.ArchFacts.repository.EnderecoRepository;
import Facts.Arch.ArchFacts.repository.NegocioRepository;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import Facts.Arch.ArchFacts.service.EnderecoService;
import Facts.Arch.ArchFacts.service.NegocioService;
import Facts.Arch.ArchFacts.service.UsuarioService;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import Facts.Arch.ArchFacts.strategy.EstrategiaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/negocios")
public class NegocioController {
    @Autowired
    private NegocioService negocioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnderecoService enderecoService;


    @PostMapping ("/{id}")
    public ResponseEntity<Negocio> cadastrarNegocio(@PathVariable UUID id,
                                                    @RequestBody Negocio negocioSolicitado) {
        Optional<Usuario> possivelAdministrador = this.usuarioRepository.findById(id);

        if (possivelAdministrador.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        if (!estadoNegocioValido(negocioSolicitado)) {
            return ResponseEntity.status(404).build();
        }

            Usuario administrador = possivelAdministrador.get();

            EstrategiaNegocio estrategiaNegocio = new EstrategiaNegocio();
            FactoryCampos factoryCampos = new FactoryCampos(estrategiaNegocio);
            factoryCampos.configurarCampos(negocioSolicitado);

            String url = "http://localhost:49152/enderecos?cep=" + negocioSolicitado.getCep();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Endereco> resposta = restTemplate.getForEntity(url, Endereco.class);

            Endereco enderecoCompleto = resposta.getBody();
            if (enderecoCompleto != null) {
                Endereco enderecoParaCadastrar = new Endereco();
                enderecoParaCadastrar.setCep(negocioSolicitado.getCep());
                enderecoParaCadastrar.setEstado(enderecoCompleto.getEstado());
                enderecoParaCadastrar.setBairro(enderecoCompleto.getBairro());
                enderecoParaCadastrar.setCidade(enderecoCompleto.getCidade());
                enderecoParaCadastrar.setRua(enderecoCompleto.getRua());

                Endereco enderecoSalvo = enderecoRepository.save(enderecoParaCadastrar);
                negocioSolicitado.setEndereco(enderecoSalvo);
                enderecoSalvo.setNegocio(negocioSolicitado);
            }

            Negocio negocioCadastrado = this.negocioRepository.save(negocioSolicitado);
            administrador.setNegocio(negocioCadastrado);
            administrador.setRole(Role.ADMINISTRADOR);

            this.usuarioRepository.save(administrador);

            return ResponseEntity.status(201).body(negocioCadastrado);
    }

    private boolean estadoNegocioValido(Negocio negocio) {
        if (negocio.getCep() == null || negocio.getCep().isEmpty()) {
            return false;
        }
        return true;
    }

    @GetMapping
    public ResponseEntity<List<Negocio>> listarNegocios() {
        List<Negocio> todosNegocios = this.negocioRepository.findAll();

        if (todosNegocios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(todosNegocios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Negocio> atualizarNegocio(@PathVariable UUID id, @RequestBody Negocio negocioSolicitado){
        if (this.negocioRepository.existsById(id)) {
            negocioSolicitado.setId(id);
            Negocio negocioAtualizado = this.negocioRepository.save(negocioSolicitado);
            return ResponseEntity.status(200).body(negocioAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping ("/{idNegocio}/{idUsuario}")
    public ResponseEntity<Void> deletarNegocio(@PathVariable UUID idNegocio, @PathVariable UUID idUsuario){
        Optional<Usuario> possivelUsuario = this.usuarioRepository.findById(idUsuario);
        if (possivelUsuario.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        if (this.negocioRepository.existsById(idNegocio)){
            Usuario usuario = possivelUsuario.get();

            if (!usuario.getRole().equals(Role.ADMINISTRADOR)) { // Não permitir excluir se ele não for adm
                return ResponseEntity.status(401).build(); // Não Autorizado
            }

            this.negocioRepository.deleteById(idNegocio);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
