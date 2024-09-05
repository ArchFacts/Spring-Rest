package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Projeto;
import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.enums.Status;
import Facts.Arch.ArchFacts.repository.ProjetoRepository;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("projetos")
public class ProjetoController {
    @Autowired
    private ProjetoRepository projetoRepository;
    private UsuarioRepository usuarioRepository;

    @PostMapping ("/{id}")
    public ResponseEntity<Projeto> cadastrarProjeto(@RequestBody Projeto projetoSolicitado,
                                                    @PathVariable UUID idUsuario) {
        Optional<Usuario> possivelDestinatario = usuarioRepository.findById(idUsuario);

        if(possivelDestinatario.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        Usuario destinatario = possivelDestinatario.get();

        projetoSolicitado.setId(null);
        projetoSolicitado.setStatus(Status.ABERTO);
        projetoSolicitado.setDestinatario(destinatario);

        return ResponseEntity.status(204).body(projetoRepository.save(projetoSolicitado));
    }

    

}
