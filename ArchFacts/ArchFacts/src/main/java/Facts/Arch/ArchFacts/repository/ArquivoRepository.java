package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArquivoRepository extends JpaRepository<Arquivo, UUID> {
}
