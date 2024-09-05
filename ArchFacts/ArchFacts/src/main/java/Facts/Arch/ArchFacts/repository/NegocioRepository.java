package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NegocioRepository extends JpaRepository<Negocio, UUID> {
}
