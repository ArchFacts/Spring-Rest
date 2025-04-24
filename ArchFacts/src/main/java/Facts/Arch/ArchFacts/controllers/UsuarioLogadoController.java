package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.UsuarioMapper;
import Facts.Arch.ArchFacts.dto.usuario.Beneficiario.UsuarioPerfilBeneficiarioDTO;
import Facts.Arch.ArchFacts.dto.usuario.Prestador.UsuarioPerfilPrestadorDTO;
import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/perfis")
public class UsuarioLogadoController {
    @Autowired
    UsuarioLogadoService usuarioLogadoService;

    @GetMapping
    public ResponseEntity<UsuarioPerfilResponseDTO> obterDadosUsuario(HttpServletRequest request) {
        String email = request.getUserPrincipal().getName();
        Usuario usuarioPerfil =  usuarioLogadoService.obterDadosPerfil(email);
        UsuarioPerfilResponseDTO dto = UsuarioMapper.toDto(usuarioPerfil);
        return ResponseEntity.status(200).body(dto);
    }

    @PutMapping
    public ResponseEntity<UsuarioPerfilBeneficiarioDTO> atualizarUsuario(
            @RequestBody UsuarioPerfilBeneficiarioDTO dto) {
        Usuario usuarioAtualizado = usuarioLogadoService.atualizarUsuarioBeneficiario(dto);

        UsuarioPerfilBeneficiarioDTO response = new UsuarioPerfilBeneficiarioDTO(usuarioAtualizado.getEmail(),
                usuarioAtualizado.getTelefone());

        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/prestador")
    public ResponseEntity<UsuarioPerfilPrestadorDTO> atualizarUsuarioPrestador(
            @RequestBody UsuarioPerfilPrestadorDTO dto) {
        Usuario usuarioAtualizado = usuarioLogadoService.atualizarUsuarioPrestador(dto);

        UsuarioPerfilPrestadorDTO response = new UsuarioPerfilPrestadorDTO(dto.getEmail(),
                dto.getCpf(),
                dto.getCnpj(),
                dto.getTelefone());

        return ResponseEntity.status(200).body(response);
    }
}