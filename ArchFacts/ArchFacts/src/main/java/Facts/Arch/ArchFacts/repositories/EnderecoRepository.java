package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}