package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.PropostaServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PropostaServicoRepository extends JpaRepository<PropostaServico, UUID> {

}
