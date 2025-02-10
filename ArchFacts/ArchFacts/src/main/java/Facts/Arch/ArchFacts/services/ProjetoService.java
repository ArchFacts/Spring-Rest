package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ProjetoExistenteException;
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
    @Autowired
    private FinanceiroService financeiroService;

    public Projeto criarProjeto (UUID idProposta) {
        Optional<Proposta> possivelProposta =  propostaRepository.findById(idProposta);

        if (possivelProposta.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar uma proposta associada");
        }

        if (possivelProposta.get().getIdProposta().equals(propostaRepository.findById(idProposta))) {
            throw new ProjetoExistenteException("Esse projeto já foi criado");
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

        Projeto projetoCadastrado = projetoRepository.save(projetoCadastro);
        propostaService.recusarProposta(idProposta);
        financeiroService.criarFinanceiro(projetoCadastrado.getIdProjeto());
        return projetoCadastrado;
    }

    public Projeto encontrarProjetoPeloId (UUID id) {
        Optional<Projeto> possivelProjeto = projetoRepository.findById(id);

        if (possivelProjeto.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um projeto");
        }
        Projeto projeto = possivelProjeto.get();
        return projeto;
    }

    public List<Projeto> encontrarTodosProjetosNegocio() {
        UUID idNegocio = usuarioLogadoService.obterNegocio().getIdNegocio();

        List<Projeto> listaProjetos = projetoRepository.findByNegocio_IdNegocio(idNegocio);

        if (listaProjetos.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar nenhum projeto");
        }

        return listaProjetos;
    }
}
