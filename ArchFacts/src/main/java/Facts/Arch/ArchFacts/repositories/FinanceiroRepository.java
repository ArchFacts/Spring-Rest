package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Financeiro;
import Facts.Arch.ArchFacts.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FinanceiroRepository extends JpaRepository <Financeiro, UUID>{
    Optional<Financeiro> findByProjeto_IdProjeto(UUID projetoId);
    List<Financeiro> findByProjeto_IdProjetoOrderByDataCriacaoAsc(UUID projetoId);
    Optional<Financeiro> findFirstByProjeto_IdProjetoOrderByDataCriacaoDesc(UUID projetoId);
}
