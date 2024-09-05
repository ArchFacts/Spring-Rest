package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.enums.Role;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private ResponseEntity<HttpStatus> verificarEstadoUsuario (Usuario usuarioSolicitado) {
        Boolean usuarioExistente = this.usuarioRepository.existsByEmail(usuarioSolicitado.getEmail());

        if (usuarioExistente) {
            Usuario usuarioCadastrado = this.usuarioRepository.findByEmail(usuarioSolicitado.getEmail());

            if (usuarioCadastrado.getAtivado()) { // Conta existe e está ativada
                return ResponseEntity.status(409).build();
            } else {
                return ResponseEntity.status(200).build(); // Conta existe e está desativada
                // Implementar método para recuperação de conta
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody Usuario usuarioSolicitado) {
        usuarioSolicitado.setId(null);

        if (verificarEstadoUsuario(usuarioSolicitado).equals(HttpStatus.NOT_FOUND)) {
            usuarioSolicitado.setRole(Role.USER);
            usuarioSolicitado.setAtivado(Boolean.TRUE);
            return ResponseEntity.status(201).body(usuarioRepository.save(usuarioSolicitado));
        }
        return verificarEstadoUsuario(usuarioSolicitado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> todosUsuarios = this.usuarioRepository.findAll();

        if (todosUsuarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(todosUsuarios);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuarioSolicitado) {
        if (this.usuarioRepository.existsById(id)) {
            usuarioSolicitado.setId(id);
            Usuario usuarioAtualizado = this.usuarioRepository.save(usuarioSolicitado);
            return ResponseEntity.status(204).body(usuarioAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable UUID id) {
        if (this.usuarioRepository.existsById(id)) {
            this.usuarioRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

}
