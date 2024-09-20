package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TicketRepository extends JpaRepository<Ticket, UUID> {
}
