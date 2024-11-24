package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PropostaRepository extends JpaRepository <Proposta, UUID> {
    List<Proposta> findByDestinatario_IdNegocio(UUID idNegocio);

}
