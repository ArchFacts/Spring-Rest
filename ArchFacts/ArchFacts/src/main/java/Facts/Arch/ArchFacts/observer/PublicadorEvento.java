package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;

public interface PublicadorEvento {
    void registrarObserver(GerenciadorEvento observer);
    void removerObserver(GerenciadorEvento observer);
    void notificarObservers(EventoResponseDTO evento);
}