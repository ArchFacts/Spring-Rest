package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.observer.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterfaceController {
    @Autowired
    private Scheduler scheduler;

//    @GetMapping
//    public ResponseEntity<String> atualizandoInterface() {
//        scheduler.verificarEventos();
//        return
//    }
}
