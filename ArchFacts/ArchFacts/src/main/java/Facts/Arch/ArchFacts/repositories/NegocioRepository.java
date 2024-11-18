package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NegocioRepository extends JpaRepository<Negocio, UUID> {
    Boolean existsByCpfOrCnpj(String cpf, String cnpj);
    Negocio findByCpfOrCnpj(String cpf, String cnpj);
    Negocio findByNome(String nome);
    @Query("SELECT AVG (n.avaliacao) FROM Negocio n WHERE n.idNegocio = :idNegocio")
    Optional<Double> encontrarMediaAvaliacaoEquals(@Param("idNegocio") UUID id);

    @Query("SELECT * FROM Negocio")
    List<Negocio> listaEmpresasParceiras();
}
