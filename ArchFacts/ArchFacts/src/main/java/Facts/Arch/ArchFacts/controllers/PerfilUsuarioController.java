package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.services.PerfilUsuarioService;
import Facts.Arch.ArchFacts.services.UsuarioService;
import com.auth0.jwt.interfaces.Claim;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/perfis")
public class PerfilUsuarioController {
    @Autowired
    PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public ResponseEntity<Usuario> obterDadosUsuario(HttpServletRequest request) {
        String email = request.getUserPrincipal().getName();
        Usuario usuarioPerfil =  perfilUsuarioService.obterDadosPerfil(email);
        return ResponseEntity.status(200).body(usuarioPerfil);
    }
}
