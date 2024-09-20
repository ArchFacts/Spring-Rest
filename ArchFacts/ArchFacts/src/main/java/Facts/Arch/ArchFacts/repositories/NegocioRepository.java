package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Negocio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NegocioRepository extends JpaRepository<Negocio, UUID> {
    Boolean existsByCpfOrCnpj(String cpf, String cnpj);
    Negocio findByCpfOrCnpj(String cpf, String cnpj);
}
