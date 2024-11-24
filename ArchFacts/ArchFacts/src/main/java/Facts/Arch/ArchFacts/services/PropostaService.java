package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    UsuarioLogadoService usuarioLogadoService;

    public Negocio buscarEmpresa(UUID id) {
        Optional<Negocio> possivelNegocio = this.negocioRepository.findById(id);
        if (possivelNegocio.isEmpty()) {
            throw new EntidadeInexistenteException("Não foi possível encontrar um negócio com esse ID %s");
        }
        Negocio negocio = possivelNegocio.get();
        return negocio;
    }

    public List<Proposta> buscarPropostas(UUID empresaId) {
        List<Proposta> listaPropostas = this.propostaRepository.findByDestinatario_IdNegocio(empresaId);

        if (listaPropostas.isEmpty()) {
            throw new ListaVaziaException("Não foi possível identificar a sua lista");
        }

        return listaPropostas;
    }
}
