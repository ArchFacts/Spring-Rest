package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TarefaRepository extends JpaRepository <Tarefa, UUID> {
//    List<Tarefa> findTarefasByNegocioId(@Param("idNegocio") UUID idNegocio);
    List<Tarefa> findByProjetoIdProjeto(@Param("idProjeto") UUID idProjeto);

}
