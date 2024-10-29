package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Scheduler {
    @Autowired
    private Notificador notificador;
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private EventoMapper eventoMapper;
    @Scheduled(fixedRate = 100000000)
    public void agendarVerificacaoEventos() {
        verificarEventos();
    }

    public void verificarEventos() {
        List<Evento> eventos = eventoRepository.findAll(); // Busca todos os eventos
        LocalDateTime dataHoje = LocalDateTime.now(); // Obtém a data atual

        for (Evento evento : eventos) {
            Long diasRestantes = notificador.calcularDiasRestantes(evento);
            Prioridade prioridadeAtual = notificador.calcularPrioridade(evento);

            EventoResponseDTO eventoResponseDTO = eventoMapper.toDto(evento);

            boolean precisaNotificar = false;

            if (!eventoResponseDTO.getDiasRestantes().equals(diasRestantes)) {
                precisaNotificar = true;

                eventoResponseDTO.setDiasRestantes(diasRestantes);
                eventoResponseDTO.setPrioridade(prioridadeAtual);
                eventoResponseDTO.setDataInicio(evento.getDataInicio());
                eventoResponseDTO.setDataTermino(evento.getDataTermino());
                eventoResponseDTO.setDescricao(evento.getDescricao());
                eventoResponseDTO.setStatus(evento.getStatus());
            }

            if (precisaNotificar) {
                notificador.notificarObservers(eventoResponseDTO);
            }
        }
    }

    public List<EventoResponseDTO> buscarEventosAtualizados() {
        List<Evento> eventos = eventoRepository.findAll();
        List<EventoResponseDTO> eventoResponseDTOS = new ArrayList<>();

        for (Evento evento : eventos) {
            EventoResponseDTO eventoResponseDTO = eventoMapper.toDto(evento);
            eventoResponseDTOS.add(eventoResponseDTO);
        }
        return eventoResponseDTOS;
    }
}
