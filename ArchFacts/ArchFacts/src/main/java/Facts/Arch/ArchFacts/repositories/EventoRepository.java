package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {
    Boolean existsByIdEntidade(UUID idEntidade);
    @Modifying
    @Query("DELETE FROM Evento e WHERE e.idEntidade = :idEntidade")
    void deleteByIdEntidade(UUID idEntidade);
}
