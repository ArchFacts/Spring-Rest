package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParcelaRepository extends JpaRepository<Parcela, UUID> {
}
