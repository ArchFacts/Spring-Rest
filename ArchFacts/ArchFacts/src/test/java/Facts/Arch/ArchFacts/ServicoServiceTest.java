package Facts.Arch.ArchFacts;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.exceptions.CamposInvalidosException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.ServicoRepository;
import Facts.Arch.ArchFacts.services.ServicoService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

class ServicoServiceTest {

    @Mock
    private UsuarioLogadoService usuarioLogadoService;

    @Mock
    private ServicoRepository servicoRepository;

    @Mock
    private NegocioRepository negocioRepository;

    @InjectMocks
    private ServicoService servicoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testVerificarEstadoServicoComCamposInvalidos() {
        Servico servico = new Servico();
        servico.setNome(null);
        servico.setDescricao("Descrição de exemplo");
        servico.setNegocio(new Negocio());

        CamposInvalidosException exception = assertThrows(CamposInvalidosException.class, () -> {
            servicoService.verificarEstadoServico(servico);
        });

        assertEquals("Os campos enviados são inválidos", exception.getMessage());
    }

    @Test
    void testCadastrarServicoComCamposValidos() {
        Servico servico = new Servico();
        servico.setNome("Serviço Exemplo");
        servico.setDescricao("Descrição de exemplo");
        Negocio negocio = new Negocio();
        negocio.setIdNegocio(UUID.randomUUID());  // Usando UUID
        servico.setNegocio(negocio);

        when(usuarioLogadoService.obterNegocio()).thenReturn(negocio);
        when(servicoRepository.save(servico)).thenReturn(servico);

        Servico servicoCadastrado = servicoService.cadastrarServico(servico);

        assertEquals("Serviço Exemplo", servicoCadastrado.getNome());
        assertEquals("Descrição de exemplo", servicoCadastrado.getDescricao());
        verify(servicoRepository, times(1)).save(servico);
    }

    @Test
    void testObterServicosDoNegocioComNegocioNaoEncontrado() {
        String codNegocio = "123";
        UUID negocioId = UUID.randomUUID();

        when(negocioRepository.findByCodigo(codNegocio)).thenReturn(Optional.empty());

        EntidadeNaoEncontradaException exception = assertThrows(EntidadeNaoEncontradaException.class, () -> {
            servicoService.obterServicosDoNegocio(codNegocio);
        });

        assertEquals("Não foi possível encontrar um negócio", exception.getMessage());
    }

    @Test
    void testObterServicosDoNegocioComServicosNaoEncontrados() {
        String codNegocio = "123";
        UUID negocioId = UUID.randomUUID();
        Negocio negocio = new Negocio();
        negocio.setIdNegocio(negocioId);

        when(negocioRepository.findByCodigo(codNegocio)).thenReturn(Optional.of(negocio));
        when(servicoRepository.findServicosByNegocioId(negocioId)).thenReturn(new ArrayList<>());

        EntidadeNaoEncontradaException exception = assertThrows(EntidadeNaoEncontradaException.class, () -> {
            servicoService.obterServicosDoNegocio(codNegocio);
        });

        assertEquals("Não foi possível encontrar uma lista", exception.getMessage());
    }

    @Test
    void testObterServicosDoNegocioComSucesso() {
        String codNegocio = "123";
        UUID negocioId = UUID.randomUUID();
        Negocio negocio = new Negocio();
        negocio.setIdNegocio(negocioId);
        Servico servico = new Servico();
        servico.setNome("Serviço Exemplo");

        when(negocioRepository.findByCodigo(codNegocio)).thenReturn(Optional.of(negocio));
        when(servicoRepository.findServicosByNegocioId(negocioId)).thenReturn(List.of(servico));

        List<Servico> servicos = servicoService.obterServicosDoNegocio(codNegocio);

        assertNotNull(servicos);
        assertEquals(1, servicos.size());
        assertEquals("Serviço Exemplo", servicos.get(0).getNome());
    }
}