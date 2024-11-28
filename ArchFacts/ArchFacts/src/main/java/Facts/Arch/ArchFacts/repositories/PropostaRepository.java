package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.entities.PropostaServico;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PropostaRepository extends JpaRepository <Proposta, UUID> {
    List<Proposta> findByDestinatario_IdNegocio(UUID idNegocio);
    Optional<Proposta> findTopByRemetente_IdUsuarioOrderByDataEnvioDesc(UUID idUsuario);
}
