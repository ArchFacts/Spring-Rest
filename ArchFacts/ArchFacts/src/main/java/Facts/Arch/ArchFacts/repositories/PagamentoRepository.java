package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
}