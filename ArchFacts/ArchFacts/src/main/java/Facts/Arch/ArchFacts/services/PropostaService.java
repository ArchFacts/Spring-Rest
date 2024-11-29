package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.PropostaRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaProposta;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropostaService {
    @Autowired
    private NegocioRepository negocioRepository;

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private NegocioService negocioService;

    public List<Proposta> buscarPropostas(UUID empresaId) {
        List<Proposta> listaPropostas = this.propostaRepository.findByDestinatario_IdNegocio(empresaId);

        if (listaPropostas.isEmpty()) {
            throw new ListaVaziaException("Não foi possível identificar a sua lista");
        }

        return listaPropostas;
    }

    public Negocio solicitacaoEnvioPropostaNegocio(String codigo) {
        Optional <Negocio> negocioOptional = this.negocioRepository.findByCodigo(codigo);

        if (negocioOptional.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar este negócio");
        }

        return negocioOptional.get();
    }


    public Proposta criarProposta(Proposta propostaSolicitada, String codigoNegocio) {

        Negocio destinatario = solicitacaoEnvioPropostaNegocio(codigoNegocio);

        Usuario remetente = usuarioLogadoService.obterSessao();

        Proposta propostaCadastro = new Proposta();
        EstrategiaProposta estrategiaProposta = new EstrategiaProposta();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaProposta);
        factoryCampos.configurarCampos(propostaCadastro);

        propostaCadastro.setTitulo(propostaSolicitada.getTitulo());
        propostaCadastro.setCep(propostaSolicitada.getCep());
        propostaCadastro.setDataEntrega(propostaSolicitada.getDataEntrega());
        propostaCadastro.setEndereco(propostaSolicitada.getEndereco());
        propostaCadastro.setNumero(propostaSolicitada.getNumero());
        propostaCadastro.setComplemento(propostaSolicitada.getComplemento());
        propostaCadastro.setDescricao(propostaSolicitada.getDescricao());

        propostaCadastro.setRemetente(remetente);
        propostaCadastro.setDestinatario(destinatario);

        return propostaRepository.save(propostaCadastro);
    }

    @Transactional
    public void recusarProposta(UUID idProposta) {
        Optional<Proposta> possivelProposta =  propostaRepository.findById(idProposta);

        if (possivelProposta.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar uma proposta associada");
        }

        Proposta propostaParaDeletar = possivelProposta.get();

        propostaRepository.deleteById(idProposta);
    }

    public Usuario encontrarSolicitanteProposta(UUID idProposta) {
        Optional<Proposta> possivelProposta =  propostaRepository.findById(idProposta);

        if (possivelProposta.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar uma proposta associada");
        }

        Usuario usuario = possivelProposta.get().getRemetente();

        return usuario;
    }

//    public Negocio encontrarDestinatarioProposta() {} (SE PRECISAR)

}
