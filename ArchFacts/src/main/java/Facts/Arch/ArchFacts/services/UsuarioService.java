package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeAtivadaException;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaUsuario;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    private Usuario verificarEstadoUsuario (Usuario usuarioSolicitado) {
        Boolean usuarioExistente = this.usuarioRepository.existsByEmail(usuarioSolicitado.getEmail());

        if (usuarioExistente) {
            Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmail(usuarioSolicitado.getEmail());

            if (usuarioOptional.isEmpty()) {
                throw new UsernameNotFoundException(String.format("Usuário %s não encontrado", usuarioSolicitado.getEmail()));
            }

            Usuario usuarioCadastrado = usuarioOptional.get();

            if (usuarioCadastrado.getAtivado()) {
                throw new EntidadeAtivadaException("Esta conta já está ativada");
            } else {
                System.out.println("Recuperar conta?"); // Iniciar método de recuperação de conta
                return usuarioCadastrado;
            }
        }
        return usuarioSolicitado;
    }


    public Usuario registrarInfos(Usuario usuarioSolicitado) {

        Usuario usuarioCadastro = verificarEstadoUsuario(usuarioSolicitado);

        EstrategiaUsuario estrategiaUsuario = new EstrategiaUsuario();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaUsuario);
        factoryCampos.configurarCampos(usuarioCadastro);

        estrategiaUsuario.configurarCampos(usuarioSolicitado);

        return usuarioCadastro;
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar (Usuario usuarioSolicitado) {
        Usuario usuarioExistente = this.usuarioRepository.findByEmail(usuarioLogadoService.obterSessao().getEmail()).orElseThrow(()
                -> new EntidadeInexistenteException("Usuário não encontrado"));

        if (usuarioExistente.getNome() != null) {
            usuarioExistente.setNome(usuarioSolicitado.getNome());
        }

        if (usuarioExistente.getEmail() != null) {
            usuarioExistente.setEmail(usuarioSolicitado.getEmail());
        }

        if (usuarioExistente.getTelefone() != null) {
            usuarioExistente.setTelefone(usuarioSolicitado.getTelefone());
        }

        Usuario usuarioAtualizado = this.usuarioRepository.save(usuarioExistente);
        return usuarioAtualizado;
    }
@Transactional
    public void deletar () {
        Usuario usuarioExistente = this.usuarioLogadoService.obterSessao();

        if (usuarioExistente.getEmail() == null) {
            throw new EntidadeNaoEncontradaException("Usuário não encontrado");
        }

        this.usuarioRepository.deleteByEmail(usuarioExistente.getEmail());
    }

    public Usuario buscarPeloEmail(String email) {
        Optional<Usuario> possivelUsuario = this.usuarioRepository.findPerfilByEmail(email);

        if (possivelUsuario.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um usuário com esse email");
        }

        return possivelUsuario.get();
    }
}
