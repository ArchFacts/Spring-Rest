package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.observer.Notificador;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    EventoMapper eventoMapper;
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    Notificador notificador;

    public EventoResponseDTO atualizarEvento(UUID idEvento, Evento eventoAtualizado) {
        Optional<Evento> eventoExistenteOptional = eventoRepository.findById(idEvento);

        if (eventoExistenteOptional.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Evento não encontrado");
        }

        Evento eventoExistente = eventoExistenteOptional.get();

        if (eventoAtualizado.getDataInicio() != null) {
            eventoExistente.setDataInicio(eventoAtualizado.getDataInicio());
        }
        if (eventoAtualizado.getDataTermino() != null) {
            eventoExistente.setDataTermino(eventoAtualizado.getDataTermino());
        }
        if (eventoAtualizado.getDescricao() != null) {
            eventoExistente.setDescricao(eventoAtualizado.getDescricao());
        }
        if (eventoAtualizado.getTipo() != null) {
            eventoExistente.setTipo(eventoAtualizado.getTipo());
        }
        if (eventoAtualizado.getStatus() != null) {
            eventoExistente.setStatus(eventoAtualizado.getStatus());
        }

        eventoRepository.save(eventoExistente);

        Long diasRestantes = notificador.calcularDiasRestantes(eventoExistente);
        EventoResponseDTO eventoResponseDTO = eventoMapper.toDto(eventoExistente);
        eventoResponseDTO.setDiasRestantes(diasRestantes);
        notificador.notificarObservers(eventoResponseDTO);

        return eventoResponseDTO;
    }
}
