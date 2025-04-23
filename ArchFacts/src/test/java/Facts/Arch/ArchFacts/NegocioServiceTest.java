package Facts.Arch.ArchFacts;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.DocumentoInvalidoException;
import Facts.Arch.ArchFacts.exceptions.EntidadeAtivadaException;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.services.NegocioService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import Facts.Arch.ArchFacts.strategy.EstrategiaNegocio;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NegocioServiceTest {

    @Mock
    private NegocioRepository negocioRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioLogadoService usuarioLogadoService;

    @InjectMocks
    private NegocioService negocioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testIdentificarTipoDocumentoComCpf() {
        String cpf = "12345678901";
        String tipoDocumento = negocioService.identificarTipoDocumento(cpf);
        assertEquals("CPF", tipoDocumento);
    }

    @Test
    void testIdentificarTipoDocumentoComCnpj() {
        String cnpj = "12345678000195";
        String tipoDocumento = negocioService.identificarTipoDocumento(cnpj);
        assertEquals("CNPJ", tipoDocumento);
    }

    @Test
    void testIdentificarTipoDocumentoComDocumentoInvalido() {
        String documento = "12345";
        assertThrows(DocumentoInvalidoException.class, () -> negocioService.identificarTipoDocumento(documento));
    }

    @Test
    void testCriarNegocioComNegocioExistenteNaoAtivado() {
        Negocio negocio = new Negocio();
        negocio.setCpf("12345678901");

        Negocio negocioExistente = new Negocio();
        negocioExistente.setCpf("12345678901");
        negocioExistente.setAtivado(false);

        when(negocioRepository.existsByCpfOrCnpj(anyString(), anyString())).thenReturn(true);
        when(negocioRepository.findByCpfOrCnpj(anyString(), anyString())).thenReturn(negocioExistente);

        Negocio negocioCriado = negocioService.criarNegocio(negocio);

        assertNotNull(negocioCriado);
        verify(negocioRepository, times(1)).save(negocio);
    }

    @Test
    void testCriarNegocioComNegocioAtivado() {
        Negocio negocio = new Negocio();
        negocio.setCpf("12345678901");

        Negocio negocioExistente = new Negocio();
        negocioExistente.setCpf("12345678901");
        negocioExistente.setAtivado(true);

        when(negocioRepository.existsByCpfOrCnpj(anyString(), anyString())).thenReturn(true);
        when(negocioRepository.findByCpfOrCnpj(anyString(), anyString())).thenReturn(negocioExistente);

        assertThrows(EntidadeAtivadaException.class, () -> negocioService.criarNegocio(negocio));
    }

    @Test
    void testBuscarEmpresaComNegocioExistente() {
        UUID id = UUID.randomUUID();
        Negocio negocio = new Negocio();
        negocio.setIdNegocio(id);

        when(negocioRepository.findById(id)).thenReturn(Optional.of(negocio));

        Negocio negocioBuscado = negocioService.buscarEmpresa(id);

        assertNotNull(negocioBuscado);
        assertEquals(id, negocioBuscado.getIdNegocio());
    }

    @Test
    void testBuscarEmpresaComNegocioNaoExistente() {
        UUID id = UUID.randomUUID();

        when(negocioRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntidadeInexistenteException.class, () -> negocioService.buscarEmpresa(id));
    }
}