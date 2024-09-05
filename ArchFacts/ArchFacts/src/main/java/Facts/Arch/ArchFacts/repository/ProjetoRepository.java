package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {
}
