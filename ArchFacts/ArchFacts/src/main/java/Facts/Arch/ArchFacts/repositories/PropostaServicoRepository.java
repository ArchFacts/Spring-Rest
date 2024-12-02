package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.dto.propostaServico.ServicoEmailDTO;
import Facts.Arch.ArchFacts.entities.PropostaServico;
import Facts.Arch.ArchFacts.entities.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PropostaServicoRepository extends JpaRepository<PropostaServico, UUID> {
    @Query("SELECT new Facts.Arch.ArchFacts.dto.propostaServico.ServicoEmailDTO(ps.servico, u.email) " +
            "FROM PropostaServico ps " +
            "JOIN ps.proposta p " +
            "JOIN ps.remetente u " +
            "WHERE p.idProposta = :idProposta")
    List<ServicoEmailDTO> findServicoAndEmailByProposta(@Param("idProposta") UUID idProposta);
    }

