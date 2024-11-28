package Facts.Arch.ArchFacts;

import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeAtivadaException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.services.UsuarioService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioLogadoService usuarioLogadoService;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarInfosUsuarioNaoAtivado() {
        Usuario usuario = new Usuario();
        usuario.setEmail("usuario@test.com");
        usuario.setAtivado(false);

        when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(false);
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioCadastrado = usuarioService.registrarInfos(usuario);

        assertNotNull(usuarioCadastrado);
        assertEquals(usuario.getEmail(), usuarioCadastrado.getEmail());
    }

    @Test
    void testVerificarEstadoUsuarioJaAtivado() {
        Usuario usuario = new Usuario();
        usuario.setEmail("usuario@test.com");
        usuario.setAtivado(true);

        when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(true);
        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(usuario));

        assertThrows(EntidadeAtivadaException.class, () -> usuarioService.registrarInfos(usuario));
    }

    @Test
    void testBuscarPeloEmail() {
        String email = "usuario@test.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);

        when(usuarioRepository.findPerfilByEmail(email)).thenReturn(Optional.of(usuario));

        Usuario encontrado = usuarioService.buscarPeloEmail(email);

        assertNotNull(encontrado);
        assertEquals(email, encontrado.getEmail());
    }

    @Test
    void testBuscarPeloEmailUsuarioNaoEncontrado() {
        String email = "usuario@test.com";

        when(usuarioRepository.findPerfilByEmail(email)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> usuarioService.buscarPeloEmail(email));
    }

    @Test
    void testDeletarUsuarioComEmailNull() {
        Usuario usuarioExistente = new Usuario();
        usuarioExistente.setEmail(null);

        when(usuarioLogadoService.obterSessao()).thenReturn(usuarioExistente);

        assertThrows(EntidadeNaoEncontradaException.class, () -> usuarioService.deletar());
    }
}