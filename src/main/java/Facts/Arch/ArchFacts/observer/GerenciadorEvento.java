package Facts.Arch.ArchFacts.observer;
import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;


public interface GerenciadorEvento  {
    void atualizar(EventoResponseDTO eventoResponseDTO);
}
