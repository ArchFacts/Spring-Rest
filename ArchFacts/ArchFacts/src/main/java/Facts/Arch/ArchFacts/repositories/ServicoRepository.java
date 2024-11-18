package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServicoRepository extends JpaRepository <Servico, UUID> {
    @Query("SELECT s FROM Servico s WHERE s.negocio.idNegocio = :idNegocio")
    List<Servico> findServicosByNegocioId(@Param("idNegocio") UUID idNegocio);

}
