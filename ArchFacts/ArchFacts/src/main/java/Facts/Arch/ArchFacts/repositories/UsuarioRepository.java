package Facts.Arch.ArchFacts.repositories;

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

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findPerfilByEmail(@Param("email") String email);

    void deleteByEmail(String email);

    @Query ("SELECT u from Usuario u WHERE u.negocio.id = :idNegocio")
    Optional<Usuario> encontrarDonoNegocioId(UUID idNegocio);

    @Query ("SELECT u from Usuario u WHERE u.negocio.codigo = :codigo")
    Optional<Usuario> encontrarDonoNegocioCodigo(String codigo);



//    @Query("SELECT new Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO(u.nome, u.email, u.telefone, u.dataRegistro, u.ativado, u.role, COALESCE(u.negocio.nome, 'Sem Negócio')) FROM Usuario u LEFT JOIN u.negocio WHERE u.email = :email")
//    Optional<UsuarioPerfilResponseDTO> findPerfilByEmail(@Param("email") String email);
}
