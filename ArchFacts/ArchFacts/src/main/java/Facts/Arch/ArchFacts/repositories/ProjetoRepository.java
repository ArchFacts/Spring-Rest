package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {
//    List<Projeto> findByNegocio_IdNegocio(UUID idNegocio);
    List<Projeto> findByDestinatario_EmailAndNegocio_NomeContainingIgnoreCase(String email, String nomeNegocio);
    @Query("SELECT p.nome FROM Projeto p WHERE p.idProjeto = :id")
    String encontrarNomePeloId(@Param("id") UUID id);

    List<Projeto> findByNegocio_IdNegocio(@Param("idNegocio") UUID idNegocio);

}
