package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository <Tarefa, UUID> {
//    List<Tarefa> findTarefasByNegocioId(@Param("idNegocio") UUID idNegocio);
    List<Tarefa> findByProjetoIdProjeto(@Param("idProjeto") UUID idProjeto);

//    @Query("SELECT new Facts.Arch.ArchFacts.dto.dashboard.GastosGeraisLucroDTO("
//            + "SUM(CASE WHEN t.dataInicio BETWEEN FUNCTION('DATE_SUB', CURRENT_DATE, 7) AND CURRENT_DATE THEN t.despesa ELSE 0 END), "
//            + "SUM(CASE WHEN t.dataInicio BETWEEN FUNCTION('DATE_SUB', CURRENT_DATE, 30) AND CURRENT_DATE THEN t.despesa ELSE 0 END), "
//            + "SUM(CASE WHEN t.dataInicio BETWEEN FUNCTION('DATE_SUB', CURRENT_DATE, 90) AND CURRENT_DATE THEN t.despesa ELSE 0 END), "
//            + "SUM(CASE WHEN t.dataInicio BETWEEN FUNCTION('DATE_SUB', CURRENT_DATE, 365) AND CURRENT_DATE THEN t.despesa ELSE 0 END)) "
//            + "FROM Tarefa t "
//            + "JOIN t.projeto p "
//            + "WHERE p.negocio.idNegocio = :idNegocio")
//    GastosGeraisDespesasDTO calcularDespesasPorNegocio(@Param("idNegocio") UUID idNegocio);

    @Query("SELECT t FROM Tarefa t WHERE t.projeto.id = :projetoId ORDER BY t.despesa DESC LIMIT 1")
    Optional<Tarefa> findTarefaMaiorDespesaPorProjeto(@Param("projetoId") UUID projetoId);

    Optional<Tarefa> findTopByProjeto_IdProjetoOrderByDespesaDesc(UUID projetoId);
}
