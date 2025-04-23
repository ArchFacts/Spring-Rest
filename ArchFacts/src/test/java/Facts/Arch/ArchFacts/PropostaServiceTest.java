package Facts.Arch.ArchFacts;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.PropostaRepository;
import Facts.Arch.ArchFacts.services.PropostaService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import Facts.Arch.ArchFacts.strategy.EstrategiaProposta;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PropostaServiceTest {

    @Mock
    private NegocioRepository negocioRepository;

    @Mock
    private PropostaRepository propostaRepository;

    @Mock
    private UsuarioLogadoService usuarioLogadoService;

    @InjectMocks
    private PropostaService propostaService;

    private UUID negocioId;
    private UUID usuarioId;
    private String codigoNegocio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        negocioId = UUID.randomUUID();
        usuarioId = UUID.randomUUID();
        codigoNegocio = "codigo123";
    }

    @Test
    void testBuscarPropostasComListaVazia() {
        when(propostaRepository.findByDestinatario_IdNegocio(negocioId)).thenReturn(List.of());

        assertThrows(ListaVaziaException.class, () -> propostaService.buscarPropostas(negocioId));
    }

    @Test
    void testBuscarPropostasComPropostasExistentes() {
        Proposta proposta = new Proposta();
        proposta.setTitulo("Proposta 1");

        when(propostaRepository.findByDestinatario_IdNegocio(negocioId)).thenReturn(List.of(proposta));

        List<Proposta> propostas = propostaService.buscarPropostas(negocioId);

        assertFalse(propostas.isEmpty());
        assertEquals("Proposta 1", propostas.get(0).getTitulo());
    }

    @Test
    void testSolicitacaoEnvioPropostaNegocioComNegocioExistente() {
        Negocio negocio = new Negocio();
        negocio.setCodigo(codigoNegocio);

        when(negocioRepository.findByCodigo(codigoNegocio)).thenReturn(Optional.of(negocio));

        Negocio negocioBuscado = propostaService.solicitacaoEnvioPropostaNegocio(codigoNegocio);

        assertNotNull(negocioBuscado);
        assertEquals(codigoNegocio, negocioBuscado.getCodigo());
    }

    @Test
    void testSolicitacaoEnvioPropostaNegocioComNegocioNaoExistente() {
        when(negocioRepository.findByCodigo(codigoNegocio)).thenReturn(Optional.empty());

        assertThrows(EntidadeNaoEncontradaException.class, () -> propostaService.solicitacaoEnvioPropostaNegocio(codigoNegocio));
    }
}