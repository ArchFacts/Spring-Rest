package Facts.Arch.ArchFacts.service;

import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.exception.EntidadeAtivadaException;
import Facts.Arch.ArchFacts.exception.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.repository.UsuarioRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaUsuario;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private Usuario verificarEstadoUsuario (Usuario usuarioSolicitado) {
        Boolean usuarioExistente = this.usuarioRepository.existsByEmail(usuarioSolicitado.getEmail());

        if (usuarioExistente) {
            Usuario usuarioCadastrado = this.usuarioRepository.findByEmail(usuarioSolicitado.getEmail());

            if (usuarioCadastrado.getAtivado()) {
                throw new EntidadeAtivadaException("Esta conta já está ativada");
            } else {
                System.out.println("Recuperar conta?"); // Iniciar método de recuperação de conta
                return usuarioCadastrado;
            }
        }
        return usuarioSolicitado;
    }

    public Usuario cadastrar (Usuario usuarioSolicitado) {
        Usuario usuarioCadastro = verificarEstadoUsuario(usuarioSolicitado);

        EstrategiaUsuario estrategiaUsuario = new EstrategiaUsuario();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaUsuario);
        factoryCampos.configurarCampos(usuarioCadastro);

        estrategiaUsuario.configurarCampos(usuarioSolicitado);

        return usuarioRepository.save(usuarioCadastro);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario atualizar (@PathVariable UUID id, Usuario usuarioSolicitado) {
        Usuario usuarioExistente = this.usuarioRepository.findById(id).orElseThrow(()
                -> new EntidadeInexistenteException("Usuário não encontrado"));

        if (usuarioSolicitado.getNome() != null) {
            usuarioExistente.setNome(usuarioSolicitado.getNome());
        }

        if (usuarioSolicitado.getEmail() != null) {
            usuarioExistente.setEmail(usuarioSolicitado.getEmail());
        }

        if (usuarioSolicitado.getSenha() != null) {
            usuarioExistente.setSenha(usuarioSolicitado.getSenha());
        }

        if (usuarioSolicitado.getTelefone() != null) {
            usuarioExistente.setTelefone(usuarioSolicitado.getTelefone());
        }

        Usuario usuarioAtualizado = this.usuarioRepository.save(usuarioExistente);
        return usuarioAtualizado;
    }

    public void deletar (@PathVariable UUID id) {
        Usuario usuarioExistente = this.usuarioRepository.findById(id).orElseThrow(()
                -> new EntidadeInexistenteException("Usuário não encontrado"));

        this.usuarioRepository.deleteById(id);
    }
}
