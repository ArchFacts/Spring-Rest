package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import Facts.Arch.ArchFacts.service.UsuarioService;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import Facts.Arch.ArchFacts.strategy.EstrategiaUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuarioSolicitado) {
        Usuario usuarioRegistrado = usuarioService.cadastrar(usuarioSolicitado);
        return ResponseEntity.status(201).body(usuarioRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuariosEncontrados = this.usuarioService.listar();

        if (usuariosEncontrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuariosEncontrados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@Valid @PathVariable UUID id, @RequestBody Usuario usuarioSolicitado) {
        Usuario usuarioAtualizado = usuarioService.atualizar(id, usuarioSolicitado);
        return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {
        this.usuarioService.deletar(id);
        return ResponseEntity.status(204).build();
    }
}
