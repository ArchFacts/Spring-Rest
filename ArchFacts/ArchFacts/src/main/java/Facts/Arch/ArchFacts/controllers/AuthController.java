package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.LoginDTO;
import Facts.Arch.ArchFacts.dto.RegistroDTO;
import Facts.Arch.ArchFacts.dto.RespostaLoginDTO;
import Facts.Arch.ArchFacts.dto.RespostaRegistroDTO;
import Facts.Arch.ArchFacts.dto.mapper.UsuarioMapper;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.security.CustomUserDetailsService;
import Facts.Arch.ArchFacts.security.TokenService;
import Facts.Arch.ArchFacts.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController  {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @PostMapping("/login")
    public ResponseEntity login (@Valid @RequestBody LoginDTO body) {
//            Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(body.getLogin());
//
//            if()
//        if (passwordEncoder.matches(body.getSenha(), usuario.getSenha())) {
//            String token = this.tokenService.gerarToken(usuario);
//            return ResponseEntity.status(200).body(new RespostaLoginDTO(usuario.getNome(), token));
//        }
//        return ResponseEntity.status(400).build();

        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(
                body.getLogin(), body.getSenha());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        Usuario usuarioAutenticado = (Usuario) auth.getPrincipal();
        String token = this.tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.status(200).body(new RespostaLoginDTO(usuarioAutenticado.getNome(), token));
    }

    @PostMapping ("/registro")
    public ResponseEntity cadastrar (@Valid @RequestBody RegistroDTO data){

        if (this.usuarioRepository.findByEmail(data.getEmail()).isPresent())
            return ResponseEntity.status(400).build();

        String senhaCriptografada = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario usuarioRegistrado = new Usuario(data.getNome(),
                data.getEmail(),
                data.getTelefone(),
                senhaCriptografada);

        this.usuarioService.cadastrar(usuarioRegistrado);
//        String token = this.tokenService.gerarToken(usuarioRegistrado);
        RespostaRegistroDTO respostaRegistroDTO = UsuarioMapper.toDto(usuarioRegistrado);
//        respostaRegistroDTO.setToken(token);

        return ResponseEntity.status(200).body(respostaRegistroDTO);
    }

    }
