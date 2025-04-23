package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import Facts.Arch.ArchFacts.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping
    ResponseEntity<List<EventoResponseDTO>> obterEventos() {
        List<EventoResponseDTO> listaDto = eventoService.encontrarEventosNegocio();
        return ResponseEntity.status(200).body(listaDto);
    }
}