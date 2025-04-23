package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.proposta.PropostaResponseDTO;
import Facts.Arch.ArchFacts.dto.tarefa.TarefaRequestDTO;
import Facts.Arch.ArchFacts.dto.tarefa.TarefaResponseDTO;
import Facts.Arch.ArchFacts.entities.Tarefa;
import org.springframework.stereotype.Component;
@Component
public class TarefaMapper {
    public Tarefa toEntity(TarefaRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setDespesa(dto.getDespesa());
        tarefa.setDataTermino(dto.getDataTermino());
        tarefa.setPrioridade(dto.getPrioridade());
        tarefa.setStatus(dto.getStatus());

        return tarefa;
    }

    public TarefaResponseDTO toDto (Tarefa tarefa) {
        if (tarefa == null) {
            return null;
        }

        TarefaResponseDTO dto = new TarefaResponseDTO();
        dto.setTitulo(tarefa.getTitulo());
        dto.setDespesa(tarefa.getDespesa());
        dto.setStatus(tarefa.getStatus());
        dto.setDataAbertura(tarefa.getDataInicio());
        dto.setDataTermino(tarefa.getDataTermino());

        return dto;
    }
}
