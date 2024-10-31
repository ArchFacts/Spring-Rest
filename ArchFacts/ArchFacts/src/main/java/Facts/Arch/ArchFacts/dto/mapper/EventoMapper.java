package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.observer.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {
    @Autowired
    private Notificador notificador;

    public EventoResponseDTO toDto(Evento evento){
        if (evento == null) {
            return null;
        }

        EventoResponseDTO dto = new EventoResponseDTO();
        dto.setDataInicio(evento.getDataInicio());
        dto.setDataTermino(evento.getDataTermino());
        dto.setTempoRestante(notificador.calcularTempoRestante(evento));
        dto.setPrioridade(notificador.calcularPrioridade(evento));
        dto.setTipo(evento.getTipo());
        dto.setDescricao(evento.getDescricao());

        return dto;
    }
}