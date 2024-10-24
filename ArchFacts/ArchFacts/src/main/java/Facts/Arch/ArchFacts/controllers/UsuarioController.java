package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import Facts.Arch.ArchFacts.services.UsuarioService;
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

//    @PostMapping
//    public ResponseEntity<RespostaRegistroDTO> cadastrar(@Valid @RequestBody RegistroDTO usuarioDTO) {
//        Usuario usuarioEntidade = UsuarioMapper.toEntity(usuarioDTO);
//        Usuario usuarioRegistrado = usuarioService.registrarInfos(usuarioEntidade);
//        RespostaRegistroDTO respostaRegistroDTO = UsuarioMapper.toDto(usuarioRegistrado);
//        return ResponseEntity.status(201).body(respostaRegistroDTO);
//    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuariosEncontrados = this.usuarioService.listar();

        if (usuariosEncontrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuariosEncontrados);
    }

    @PutMapping()
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuarioSolicitado) {
        Usuario usuarioAtualizado = usuarioService.atualizar(usuarioSolicitado);
        return ResponseEntity.status(200).body(usuarioAtualizado);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletar() {
        this.usuarioService.deletar();
        return ResponseEntity.status(204).build();
    }
}
