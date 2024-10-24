package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enums.Role;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaNegocio;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.Optional;

@Service
public class UsuarioLogadoService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public Usuario obterDadosPerfil(@PathVariable String email) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findPerfilByEmail(email);
        if (usuarioEncontrado.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi encontrado um usuário");
        }
        return usuarioEncontrado.get();
    }

    public Usuario obterSessao() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            String email = authentication.getName();
            return obterDadosPerfil(email);
        }

        throw new EntidadeNaoEncontradaException("Usuário não está autenticado");
    }

    public void adicionarNegocioAoUsuario(Negocio negocio) {
        Usuario usuario = obterSessao();

        usuario.setNegocio(negocio);
        usuario.setRole(Role.ADM);
    }
}
