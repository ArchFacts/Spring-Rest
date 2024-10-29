package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.observer.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventoController {
    @Autowired
    private Notificador notificador;

}
