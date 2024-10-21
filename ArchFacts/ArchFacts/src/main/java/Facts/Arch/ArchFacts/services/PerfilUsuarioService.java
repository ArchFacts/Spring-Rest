package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Service
public class PerfilUsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public UsuarioPerfilResponseDTO obterDadosPerfil(@PathVariable UUID id) {
        Optional<UsuarioPerfilResponseDTO> usuarioEncontrado = usuarioRepository.findByPerfilId(id);
        if (usuarioEncontrado.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi encontrado um usuário");
        }
        return usuarioEncontrado.get();
    }
}
