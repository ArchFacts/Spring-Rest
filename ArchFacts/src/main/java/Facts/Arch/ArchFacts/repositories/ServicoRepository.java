package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ServicoRepository extends JpaRepository <Servico, UUID> {
    @Query("SELECT s FROM servico s WHERE s.negocio.idNegocio = :idNegocio")
    List<Servico> findServicosByNegocioId(@Param("idNegocio") UUID idNegocio);

    @Query("SELECT s FROM servico s WHERE s.idServico = :idServico")
    Servico encontrarServicoPeloId(@Param("idServico") UUID idServico);

}
