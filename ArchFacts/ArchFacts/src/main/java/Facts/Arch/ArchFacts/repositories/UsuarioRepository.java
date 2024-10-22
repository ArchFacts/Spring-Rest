package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);

//    @Query("SELECT new UsuarioPerfilResponseDTO(u.nome, u.email, u.telefone, u.dataRegistro, u.ativado, u.role, u.negocio.nome) FROM Usuario u WHERE u.email = :email")
//    Optional<UsuarioPerfilResponseDTO> findPerfilByEmail(@Param("email") String email);
}
