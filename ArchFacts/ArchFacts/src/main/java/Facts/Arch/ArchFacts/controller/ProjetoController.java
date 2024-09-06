package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Projeto;
import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.enums.Status;
import Facts.Arch.ArchFacts.repository.NegocioRepository;
import Facts.Arch.ArchFacts.repository.ProjetoRepository;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import Facts.Arch.ArchFacts.strategy.ConfiguradorDeCampos;
import Facts.Arch.ArchFacts.strategy.EstrategiaProjeto;
import Facts.Arch.ArchFacts.strategy.EstrategiaUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private NegocioRepository negocioRepository;

    @PostMapping ("/{idDestinatario}/{idNegocio}")
    public ResponseEntity<Projeto> cadastrarProjeto(@PathVariable UUID idDestinatario,
                                                    @PathVariable UUID idNegocio,
                                                    @RequestBody Projeto projetoSolicitado) {

        Optional<Usuario> possivelDestinatario = usuarioRepository.findById(idDestinatario);
        Optional<Negocio> possivelNegocio = negocioRepository.findById(idNegocio);

        if (possivelDestinatario.isEmpty() || possivelNegocio.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        Usuario destinatario = possivelDestinatario.get();
        Negocio negocio = possivelNegocio.get();

        EstrategiaProjeto estrategiaProjeto = new EstrategiaProjeto(destinatario, negocio);
        ConfiguradorDeCampos configuradorDeCampos = new ConfiguradorDeCampos(estrategiaProjeto);
        configuradorDeCampos.configurarCampos(projetoSolicitado);

//        projetoSolicitado.setId(null);
//        projetoSolicitado.setStatus(Status.ABERTO);
//        projetoSolicitado.setDestinatario(destinatario);
//        projetoSolicitado.setDataInicio(LocalDate.now());
//        projetoSolicitado.setNegocio(negocio);

        return ResponseEntity.status(201).body(projetoRepository.save(projetoSolicitado));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listarProjetos() {
        List<Projeto> todosProjetos = projetoRepository.findAll();

        if (todosProjetos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(todosProjetos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable UUID id, @RequestBody Projeto projetoSolicitado) {
        if (this.projetoRepository.existsById(id)) {
            projetoSolicitado.setId(id);
            Projeto projetoAtualizado = this.projetoRepository.save(projetoSolicitado);
            return ResponseEntity.status(200).body(projetoAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable UUID id) {
        if (this.projetoRepository.existsById(id)) {
            this.projetoRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
