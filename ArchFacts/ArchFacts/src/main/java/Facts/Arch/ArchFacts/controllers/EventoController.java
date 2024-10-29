package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.observer.Notificador;
import Facts.Arch.ArchFacts.observer.Scheduler;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import Facts.Arch.ArchFacts.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private Scheduler scheduler;
    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private EventoMapper eventoMapper;

    @GetMapping("/atualizados")
    public ResponseEntity<List<EventoResponseDTO>> obterEventosAtualizados() {
        List<EventoResponseDTO> dtos = scheduler.buscarEventosAtualizados();

        if (dtos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping()
    public ResponseEntity<List<EventoResponseDTO>> listarEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        if (eventos.isEmpty()){
            ResponseEntity.status(204).build();
        }

        List<EventoResponseDTO> dtos = new ArrayList<>();

        for (Evento evento : eventos) {
            eventoMapper.toDto(evento);
            eventos.add(evento);
        }

        return ResponseEntity.status(200).body(dtos);
    }

    @PutMapping("/{idEvento}")
    public ResponseEntity<EventoResponseDTO> atualizarEvento(@PathVariable UUID idEvento
            , @RequestBody Evento eventoSolicitado) {
        EventoResponseDTO eventoAtualizado = eventoService.atualizarEvento(idEvento, eventoSolicitado);
        return ResponseEntity.status(200).body(eventoAtualizado);
    }
}