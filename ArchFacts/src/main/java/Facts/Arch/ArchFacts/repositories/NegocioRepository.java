package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NegocioRepository extends JpaRepository<Negocio, UUID> {
    Boolean existsByCpfOrCnpj(String cpf, String cnpj);
    Negocio findByCpfOrCnpj(String cpf, String cnpj);
    Negocio findByNome(String nome);
    @Query("SELECT AVG (n.avaliacao) FROM negocio n WHERE n.idNegocio = :idNegocio")
    Optional<Double> encontrarMediaAvaliacaoEquals(@Param("idNegocio") UUID id);
    Optional<Negocio> findByCodigo(String codigo);

}