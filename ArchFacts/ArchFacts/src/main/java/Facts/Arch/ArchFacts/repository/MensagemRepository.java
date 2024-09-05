package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MensagemRepository extends JpaRepository<Mensagem, UUID> {
}
