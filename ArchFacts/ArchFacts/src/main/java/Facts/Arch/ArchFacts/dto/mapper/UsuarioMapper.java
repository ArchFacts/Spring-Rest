package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.RegistroDTO;
import Facts.Arch.ArchFacts.dto.RespostaUsuarioDTO;
import Facts.Arch.ArchFacts.entities.Usuario;

public class UsuarioMapper {
    public static RespostaUsuarioDTO toDto(Usuario usuario){
        if (usuario == null) {
            return null;
        }

        RespostaUsuarioDTO dto = new RespostaUsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTelefone(usuario.getTelefone());

        return dto;
    }

    public static Usuario toEntity(RegistroDTO dto) {
        if (dto == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        return usuario;
    }

//    public static Usuario toEntity(RegistroDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//
//        Usuario usuario = new Usuario();
//        usuario.setEmail(dto.getEmail());
//        usuario.setSenha(dto.getSenha());
//        return usuario;
//    }
}
