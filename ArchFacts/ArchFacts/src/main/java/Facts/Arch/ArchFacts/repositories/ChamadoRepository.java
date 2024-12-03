package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChamadoRepository extends JpaRepository<Chamado, UUID> {
    List<Chamado> findByProjetoIdProjeto(UUID idProjeto);

    @Modifying
    @Query("UPDATE Chamado c SET c.lucro = :lucro WHERE c.idChamado = :idChamado")
    void atualizarLucro(@Param("idChamado") UUID idChamado, @Param("lucro") Double lucro);

}
