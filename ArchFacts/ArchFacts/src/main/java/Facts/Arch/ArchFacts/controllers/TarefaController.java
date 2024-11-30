package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.TarefaMapper;
import Facts.Arch.ArchFacts.dto.tarefa.TarefaRequestDTO;
import Facts.Arch.ArchFacts.dto.tarefa.TarefaResponseDTO;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.services.ProjetoService;
import Facts.Arch.ArchFacts.services.TarefaService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaService tarefaService;
    @Autowired
    UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private TarefaMapper tarefaMapper;

    @Autowired
    private ProjetoService projetoService;
    @GetMapping("/{idProjeto}")
    public ResponseEntity<List<Tarefa>> buscarTarefas(@PathVariable UUID idProjeto) {
        List<Tarefa> listaTarefas = this.tarefaService.buscarTarefas
                (idProjeto);

        return ResponseEntity.status(200).body(listaTarefas);
    }
    @PostMapping("/{idProjeto}")
    public ResponseEntity<TarefaResponseDTO> cadastrar(@Valid @RequestBody TarefaRequestDTO dto,
                                                       @PathVariable UUID idProjeto) {
        Tarefa tarefa = tarefaMapper.toEntity(dto);
        TarefaResponseDTO resposta = tarefaMapper.toDto(tarefaService.criarTarefa(idProjeto, tarefa));
        return ResponseEntity.status(200).body(resposta);
    }
}
