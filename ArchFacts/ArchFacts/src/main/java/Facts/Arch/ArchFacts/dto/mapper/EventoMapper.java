package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {
    @Autowired
    private EventoService eventoService;

    public EventoResponseDTO toDto(Evento evento){
        if (evento == null) {
            return null;
        }
        EventoResponseDTO dto = new EventoResponseDTO();

        dto.setTipo(evento.getTipo());
        dto.setDescricao(evento.getDescricao());
        dto.setDataCriacao(evento.getDataCriacao());
        dto.setDataEncerramento(evento.getDataTermino());
        dto.setStatus(evento.getStatus());
        dto.setPrioridade(evento.getPrioridade());
        dto.setNomeProjeto(evento.getProjeto().getNome());
        dto.setNomeNegocio(evento.getNegocio().getNome());

        return dto;
    }
}
