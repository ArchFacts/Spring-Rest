package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.observer.Notificador;
import Facts.Arch.ArchFacts.observer.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private Notificador notificador;

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/eventos/atualizados")
    public ResponseEntity<List<EventoResponseDTO>> obterEventosAtualizados() {
        List<EventoResponseDTO> dtos = scheduler.buscarEventosAtualizados();

        if (dtos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(dtos);
    }

    @PutMapping("/{idEvento}")
    public ResponseEntity<EventoResponseDTO> atualizarEvento(@PathVariable UUID idEvento
            ,@RequestBody Evento eventoSolicitado) {
        EventoResponseDTO eventoAtualizado = notificador.atualizarEvento(idEvento, eventoSolicitado);
        return ResponseEntity.status(200).body(eventoAtualizado);
    }
}
