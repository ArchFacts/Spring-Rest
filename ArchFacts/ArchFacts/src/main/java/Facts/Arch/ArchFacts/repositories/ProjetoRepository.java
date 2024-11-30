package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {
    List<Projeto> findByNegocio_IdNegocio(UUID idNegocio);
}
