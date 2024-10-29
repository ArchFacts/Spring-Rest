package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class Notificador implements PublicadorEvento {
    @Autowired
    private EventoRepository eventoRepository;

    private final List<GerenciadorEvento> observers = new ArrayList<>();

    public Long calcularDiasRestantes(Evento evento) {
        LocalDateTime dataHoje = LocalDateTime.now();
        LocalDateTime prazoFinal = evento.getDataTermino();

        Long diasRestantes = ChronoUnit.DAYS.between(dataHoje, prazoFinal);
        return diasRestantes;
    }

    public Prioridade calcularPrioridade(Evento evento) {
        Long diasRestantes = calcularDiasRestantes(evento);
        Prioridade definirPrioridade = null;
        if (diasRestantes <= 7 && diasRestantes >= 5) {
            definirPrioridade = Prioridade.BAIXA;
        } else if (diasRestantes <= 4) {
            definirPrioridade = Prioridade.MEDIA;
        } else {
            definirPrioridade = Prioridade.ALTA;
        }
        return definirPrioridade;
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
