package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
