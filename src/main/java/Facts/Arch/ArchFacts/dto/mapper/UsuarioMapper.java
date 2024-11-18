package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.usuario.UsuarioPerfilResponseDTO;
import Facts.Arch.ArchFacts.entities.Usuario;

public class UsuarioMapper {
    public static UsuarioPerfilResponseDTO toDto(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioPerfilResponseDTO dto = new UsuarioPerfilResponseDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());
        dto.setDataRegistro(usuario.getDataRegistro());
        dto.setAtivado(usuario.getAtivado());
        dto.setRole(usuario.getRole());
        dto.setNegocio(usuario.getNegocio() != null ? usuario.getNegocio().getNome() : "Sem negócio");

        return dto;
    }
}
