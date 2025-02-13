package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventoRepository extends JpaRepository<Evento, UUID> {
    
}
