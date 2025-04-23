package Facts.Arch.ArchFacts.dto.mapper;
import Facts.Arch.ArchFacts.dto.chamado.ChamadoRequestDTO;
import Facts.Arch.ArchFacts.dto.chamado.ChamadoResponseDTO;
import Facts.Arch.ArchFacts.entities.Chamado;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ChamadoMapper {
    public Chamado toEntity(ChamadoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Chamado chamado = new Chamado();
        chamado.setDescricao(dto.getDescricao());
        chamado.setFechamento(dto.getFechamento());
        chamado.setStatus(dto.getStatus());
        chamado.setLucro(dto.getLucro());
        chamado.setAbertura(LocalDateTime.now());
        chamado.setTitulo(dto.getTitulo());

        return chamado;
    }

    public ChamadoResponseDTO toDto (Chamado chamado) {
        if (chamado == null) {
            return null;
        }

        ChamadoResponseDTO dto = new ChamadoResponseDTO();
        dto.setDescricao(chamado.getDescricao());
        dto.setDataFechamento(chamado.getFechamento());
        dto.setDataAbertura(chamado.getAbertura());
        dto.setStatus(chamado.getStatus());
        dto.setTitulo(chamado.getTitulo());
        dto.setLucro(chamado.getLucro());

        return dto;
    }
}
