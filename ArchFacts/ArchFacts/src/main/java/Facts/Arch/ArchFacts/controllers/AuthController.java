package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.AuthDTO;
import Facts.Arch.ArchFacts.dto.RegistroDTO;
import Facts.Arch.ArchFacts.dto.RespostaUsuarioDTO;
import Facts.Arch.ArchFacts.dto.mapper.UsuarioMapper;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login (@Valid @RequestBody AuthDTO data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                data.getLogin(), data.getSenha());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.status(200).build();
    }

    @PostMapping ("/registro")
    public ResponseEntity cadastrar (@Valid @RequestBody RegistroDTO data){
        if (this.usuarioRepository.findByEmail(data.getEmail()) != null)
            return ResponseEntity.status(400).build();

        String senhaEncriptografada = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario usuarioRegistrado = new Usuario(data.getNome(),
                data.getTelefone(),
                data.getEmail(),
                senhaEncriptografada);
        RespostaUsuarioDTO usuarioDTO = UsuarioMapper.toDto(usuarioRegistrado);

        this.usuarioService.cadastrar(usuarioRegistrado);

        return ResponseEntity.status(200).body(usuarioDTO);
    }
}
