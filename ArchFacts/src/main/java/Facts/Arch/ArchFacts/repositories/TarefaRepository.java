package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Tarefa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository <Tarefa, UUID> {
//    List<Tarefa> findTarefasByNegocioId(@Param("idNegocio") UUID idNegocio);
    List<Tarefa> findByProjetoIdProjeto(@Param("idProjeto") UUID idProjeto);
    @Query("SELECT t FROM Tarefa t WHERE t.projeto.id = :projetoId ORDER BY t.despesa DESC LIMIT 1")
    Optional<Tarefa> findTarefaMaiorDespesaPorProjeto(@Param("projetoId") UUID projetoId);
    Optional<Tarefa> findTopByProjeto_IdProjetoOrderByDespesaDesc(UUID projetoId);
    List<Tarefa> findByProjeto_Negocio_IdNegocio(@Param("idNegocio") UUID idNegocio);
    long countByProjeto_IdProjeto(UUID projetoId);
}
