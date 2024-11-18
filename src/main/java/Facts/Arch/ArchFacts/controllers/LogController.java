package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.system.FiltroLogs;
import Facts.Arch.ArchFacts.system.ListaEstatica;
import Facts.Arch.ArchFacts.system.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    @Autowired
    private FiltroLogs filtroLogs;
    @Autowired
    private ListaEstatica logList;

    @GetMapping
    private ResponseEntity<List<SystemLog>> listar() {
        List<SystemLog> listaLogs = logList.pegarVetor();

        if (listaLogs.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(listaLogs);
    }
    @GetMapping("/{horario}")
    private ResponseEntity<SystemLog> buscar(@PathVariable LocalDateTime horario) {
        List<SystemLog> listaOrdenada = logList.pegarVetor();
        Integer index = logList.pesquisaBinariaHorario(listaOrdenada, horario);

        if (index == -1) {
            return ResponseEntity.status(404).build();
        }

        SystemLog log = logList.pegarVetor().get(index);
        return ResponseEntity.status(200).body(log);
    }
}
