package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.entities.PropostaServico;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PropostaRepository extends JpaRepository <Proposta, UUID> {
    List<Proposta> findByDestinatario_IdNegocio(UUID idNegocio);
    Optional<Proposta> findTopByRemetente_IdUsuarioOrderByDataEnvioDesc(UUID idUsuario);
//    void deleteByIdProposta(@Param("idProposta") UUID idProposta);
    @Query("DELETE FROM proposta p WHERE p.id = :idProposta")
    void deleteByIdStringVersion(@Param("idProposta") String idProposta);

}
