package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, UUID> {
    List<Chamado> findByProjetoIdProjeto(UUID idProjeto);
}
