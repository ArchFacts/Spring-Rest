package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {
}
