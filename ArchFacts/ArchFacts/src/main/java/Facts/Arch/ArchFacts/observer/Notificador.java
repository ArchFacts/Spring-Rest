package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Component
public class Notificador implements PublicadorEvento {
    @Autowired
    private EventoRepository eventoRepository;

    private final List<GerenciadorEvento> observers = new ArrayList<>();

    public String calcularTempoRestante(Evento evento) {
        LocalDateTime dataHoje = LocalDateTime.now();
        LocalDateTime prazoFinal = evento.getDataTermino();

        Long diasRestantes = ChronoUnit.DAYS.between(dataHoje, prazoFinal);
        long horasRestantes = ChronoUnit.HOURS.between(dataHoje.plusDays(diasRestantes), prazoFinal);
        long minutosRestantes = ChronoUnit.MINUTES.between(dataHoje.plusDays(diasRestantes).plusHours(horasRestantes), prazoFinal);
        return "%d dias, %d horas e %d minutos".formatted(diasRestantes, horasRestantes, minutosRestantes);
    }

    public Prioridade calcularPrioridade(Evento evento) {
        String tempoRestante = calcularTempoRestante(evento);
        Integer diasRestantes = extrairDias(tempoRestante);

        Prioridade definirPrioridade;
        if (diasRestantes <= 7 && diasRestantes >= 5) {
            definirPrioridade = Prioridade.BAIXA;
        } else if (diasRestantes <= 4) {
            definirPrioridade = Prioridade.MEDIA;
        } else {
            definirPrioridade = Prioridade.ALTA;
        }
        return definirPrioridade;
    }

    public Integer extrairDias(String tempoRestante) {
        String[] partes = tempoRestante.split(" ");
        if (partes.length > 0) {
            return Integer.parseInt(partes[0]);
        }
        throw new NumberFormatException();
    }


    @Override
    public void registrarObserver(GerenciadorEvento observer) {

    }

    @Override
    public void removerObserver(GerenciadorEvento observer) {

    }

    @Override
    public void notificarObservers(EventoResponseDTO evento) {
        for (GerenciadorEvento observer : observers){
            observer.atualizar(evento);
        }
    }
}
