package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.usuario.Beneficiario.UsuarioPerfilBeneficiarioDTO;
import Facts.Arch.ArchFacts.dto.usuario.Prestador.UsuarioPerfilPrestadorDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enumeration.Role;
import Facts.Arch.ArchFacts.exceptions.EmailExistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class UsuarioLogadoService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    NegocioRepository negocioRepository;

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

        if (usuario == null) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um usuário");
        }

        usuario.setNegocio(negocio);
        usuario.setRole(Role.ADM);
    }

    public Negocio obterNegocio() {
        if (obterSessao().getNegocio() == null) {
            throw new EntidadeNaoEncontradaException("Usuário não tem um negócio");
        }

        return obterSessao().getNegocio();
    }

    public Usuario atualizarUsuarioBeneficiario(UsuarioPerfilBeneficiarioDTO dto) {
        Usuario usuario = obterSessao();

        if (usuario == null) {
            throw new EntidadeInexistenteException("Este usuário não existe");
        }

        if (dto.getEmail() != null &&
                !dto.getEmail().isEmpty() &&
        !dto.getEmail().equals(usuario.getEmail())) {
            Boolean emailExistente = usuarioRepository.existsByEmail(dto.getEmail());
            if (emailExistente) {
                throw new EmailExistenteException("Este e-mail já está em uso");
            }
        }

        usuario.setEmail(dto.getEmail());

        if (dto.getTelefone() != null && !dto.getTelefone().isEmpty()){
            usuario.setTelefone(dto.getTelefone());
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuarioPrestador(UsuarioPerfilPrestadorDTO dto) {
        Usuario usuario = obterSessao();

        if (usuario == null) {
            throw new EntidadeInexistenteException("Este usuário não existe");
        }

        if (dto.getEmail() != null &&
                !dto.getEmail().isEmpty() &&
                !dto.getEmail().equals(usuario.getEmail())) {
            Boolean emailExistente = usuarioRepository.existsByEmail(dto.getEmail());
            if (emailExistente) {
                throw new EmailExistenteException("Este e-mail já está em uso");
            }
        }

        usuario.setEmail(dto.getEmail());


        if (usuario.getNegocio() == null) {
            throw new EntidadeNaoEncontradaException("Não possível encontrar o negócio deste usuário");
        } else {
            Negocio negocio = usuario.getNegocio();

            if (dto.getCpf() != null && !dto.getCpf().isEmpty()) {
                negocio.setCpf(dto.getCpf());
            }

            if (dto.getCnpj() != null && !dto.getCnpj().isEmpty()) {
                negocio.setCnpj(dto.getCnpj());
            }

            if (dto.getTelefone() != null && !dto.getTelefone().isEmpty()){
                usuario.setTelefone(dto.getTelefone());
            }
            negocioRepository.save(negocio);
        }
        return usuarioRepository.save(usuario);
    }
}
