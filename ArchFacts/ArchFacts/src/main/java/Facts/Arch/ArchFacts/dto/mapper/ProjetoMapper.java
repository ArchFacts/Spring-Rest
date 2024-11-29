package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.projeto.ProjetoRequestDTO;
import Facts.Arch.ArchFacts.dto.projeto.ProjetoResponseDTO;
import Facts.Arch.ArchFacts.entities.Projeto;
import org.springframework.stereotype.Component;

@Component
public class ProjetoMapper {
    public static ProjetoResponseDTO toDto(Projeto projeto) {
        if (projeto == null) {
            return null;
        }

        ProjetoResponseDTO dto = new ProjetoResponseDTO();
        dto.setNome(projeto.getNome());
        dto.setDescricao(projeto.getDescricao());
        dto.setDataEntrega(projeto.getDataEntrega());
        dto.setStatus(projeto.getStatus());

        return dto;
    }

    public static Projeto toEntity(ProjetoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Projeto projeto = new Projeto();
        projeto.setNome(dto.getNome());
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataEntrega(dto.getDataEntrega());

        return projeto;
    }
}
