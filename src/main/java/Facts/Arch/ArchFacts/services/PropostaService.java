package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PropostaService {
    @Autowired
    private NegocioRepository negocioRepository;
    public Negocio buscarSolicitante(UUID id) {
        Optional<Negocio> possivelNegocio = this.negocioRepository.findById(id);
        if (possivelNegocio.isEmpty()) {
            throw new EntidadeInexistenteException("Não foi possível encontrar um negócio com esse ID %s");
        }
        Negocio negocio = possivelNegocio.get();
        return negocio;
    }
}
