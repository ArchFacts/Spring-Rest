package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Boolean existsByEmail(String email);
    Usuario findByEmail(String email);
}
