package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArquivoRepository extends JpaRepository<Arquivo, UUID> {
}
