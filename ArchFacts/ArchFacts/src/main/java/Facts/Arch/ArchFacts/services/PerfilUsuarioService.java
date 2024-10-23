package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.mapper.UsuarioMapper;
import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class PerfilUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public Usuario obterDadosPerfil(@PathVariable String email) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findPerfilByEmail(email);
        if (usuarioEncontrado.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi encontrado um usuário");
        }
        return usuarioEncontrado.get();
    }
}
