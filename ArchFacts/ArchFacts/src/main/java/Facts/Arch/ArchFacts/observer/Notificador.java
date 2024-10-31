package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Notificador implements PublicadorEvento {
    @Autowired
    private EventoRepository eventoRepository;

    private final List<GerenciadorEvento> observers = new ArrayList<>();

    @Override
    public void registrarObserver(GerenciadorEvento observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(GerenciadorEvento observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(EventoResponseDTO evento) {
        for (GerenciadorEvento observer : observers){
            observer.atualizar(evento);
        }
    }
}
