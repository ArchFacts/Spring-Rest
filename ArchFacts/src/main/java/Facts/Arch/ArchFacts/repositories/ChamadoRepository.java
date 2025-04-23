package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Tarefa;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, UUID> {
    List<Chamado> findByProjetoIdProjeto(UUID idProjeto);
    @Modifying
    @Query("UPDATE Chamado c SET c.lucro = :lucro WHERE c.idChamado = :idChamado")
    void atualizarLucro(@Param("idChamado") UUID idChamado, @Param("lucro") Double lucro);
    @Query("SELECT c FROM Chamado c WHERE c.projeto.id = :projetoId ORDER BY c.lucro DESC LIMIT 1")
    Optional<Chamado> findChamadoMaiorLucroPorProjeto(@Param("projetoId") UUID projetoId);
    Optional<Chamado> findTopByProjeto_IdProjetoOrderByLucroDesc(UUID projetoId);
    List<Chamado> findByProjeto_Negocio_IdNegocio(@Param("idNegocio") UUID idNegocio);
    long countByProjeto_IdProjeto(UUID projetoId);

}
