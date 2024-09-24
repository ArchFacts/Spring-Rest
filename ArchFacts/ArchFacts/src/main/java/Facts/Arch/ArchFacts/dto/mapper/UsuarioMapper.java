package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.RegistroDTO;
import Facts.Arch.ArchFacts.dto.RespostaRegistroDTO;
import Facts.Arch.ArchFacts.entities.Usuario;

public class UsuarioMapper {
    public static RespostaRegistroDTO toDto(Usuario usuario){
        if (usuario == null) {
            return null;
        }

        RespostaRegistroDTO dto = new RespostaRegistroDTO();
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
