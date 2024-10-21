package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.services.PerfilUsuarioService;
import com.auth0.jwt.interfaces.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/perfis")
public class PerfilUsuarioController {
    @Autowired
    PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public ResponseEntity<Usuario> obterDadosUsuario(@RequestHeader("Authorization") String token) {
        UsuarioPerfilResponseDTO usuarioPerfil = perfilUsuarioService.obterDadosPerfil()
    }
}
