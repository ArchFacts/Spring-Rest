package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PagamentoRepository extends JpaRepository<Pagamento, UUID> {
}
