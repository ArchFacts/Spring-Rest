package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import Facts.Arch.ArchFacts.repositories.PropostaRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaProjeto;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjetoService {
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;
    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private PropostaRepository propostaRepository;
    @Autowired
    private PropostaService propostaService;

    public Projeto criarProjeto (UUID idProposta) {
        Optional<Proposta> possivelProposta =  propostaRepository.findById(idProposta);

        if (possivelProposta.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar uma proposta associada");
        }
        Proposta dadosProjeto = possivelProposta.get();
        Projeto projetoCadastro = new Projeto();

        EstrategiaProjeto estrategiaProjeto = new EstrategiaProjeto();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaProjeto);
        factoryCampos.configurarCampos(projetoCadastro);

        projetoCadastro.setNome(dadosProjeto.getTitulo());
        projetoCadastro.setDescricao(dadosProjeto.getDescricao());
        projetoCadastro.setDataEntrega(dadosProjeto.getDataEntrega());
        factoryCampos.configurarCampos(projetoCadastro);

        Usuario usuarioSolicitante = propostaService.encontrarSolicitanteProposta(idProposta);
        Negocio negocioDestinado = usuarioLogadoService.obterNegocio();

        projetoCadastro.setDestinatario(usuarioSolicitante);
        projetoCadastro.setNegocio(negocioDestinado);

        propostaService.recusarProposta(idProposta);

        return projetoRepository.save(projetoCadastro);
    }
}
