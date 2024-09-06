package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.enums.Role;
import Facts.Arch.ArchFacts.repository.NegocioRepository;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/negocios")
public class NegocioController {
    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private ResponseEntity<ResponseStatus> verificarEstadoNegocio (Negocio negocioSolicitado) {
        Boolean negocioExistente = this.negocioRepository.existsByCpfOrCnpj(negocioSolicitado.getCpf(),
                negocioSolicitado.getCnpj());

        if (negocioExistente) {
            Negocio negocioCadastrado = this.negocioRepository.findByCpfOrCnpj(negocioSolicitado.getCpf(),
                    negocioSolicitado.getCnpj());

            if (negocioCadastrado.getAtivado()) { // Conta existe e está ativada
                return ResponseEntity.status(409).build();
            } else {
                return ResponseEntity.status(200).build(); // Conta existe e está desativada
                // Implementar método para recuperação de conta
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping ("/{id}")
    public ResponseEntity<Negocio> cadastrarNegocio(@PathVariable UUID id,
                                                    @RequestBody Negocio negocioSolicitado) {
        Optional<Usuario> possivelAdministrador = this.usuarioRepository.findById(id);

        if (possivelAdministrador.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        if (verificarEstadoNegocio(negocioSolicitado).equals(ResponseEntity.status(404).build())) {
            Usuario administrador = possivelAdministrador.get();

            negocioSolicitado.setId(null);
            negocioSolicitado.setAtivado(Boolean.TRUE);
            negocioSolicitado.setCodigoNegocio(UUID.randomUUID().toString());
            negocioSolicitado.setDataRegistro(LocalDate.now());

            Negocio negocioCadastrado = this.negocioRepository.save(negocioSolicitado);
            administrador.setNegocio(negocioCadastrado);
            administrador.setRole(Role.ADMINISTRADOR);

            this.usuarioRepository.save(administrador);

            return ResponseEntity.status(201).body(negocioCadastrado);
        }
        return ResponseEntity.status(404).build();
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
