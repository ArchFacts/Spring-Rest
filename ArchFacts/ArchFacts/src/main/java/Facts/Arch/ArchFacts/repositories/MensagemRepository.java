package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MensagemRepository extends JpaRepository<Mensagem, UUID> {
}
