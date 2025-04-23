package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.exceptions.CamposInvalidosException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    public Servico verificarEstadoServico (Servico servico) {
        if (servico.getNome() == null ||
        servico.getDescricao() == null ||
        servico.getNegocio() == null) {
            throw new CamposInvalidosException("Os campos enviados são inválidos");
        }
        return servico;
    }

    public Servico cadastrarServico (Servico servico) {
        Servico servicoCadastro = servico;
        verificarEstadoServico(servicoCadastro);
        servicoCadastro.setNegocio(usuarioLogadoService.obterNegocio());

        return servicoRepository.save(servico);
    }

    public List<Servico> obterServicosDoNegocio(String codNegocio) {
        Optional<Negocio> negocioOptional = negocioRepository.findByCodigo(codNegocio);

        if (negocioOptional.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um negócio");
        }

        Negocio negocio = negocioOptional.get();

        List<Servico> listaServicos = servicoRepository.findServicosByNegocioId(negocio.getIdNegocio());

        if (listaServicos.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar uma lista");
        }

        return listaServicos;
    }
}
