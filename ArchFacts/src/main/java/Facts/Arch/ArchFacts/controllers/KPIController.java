package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.dashboard.ChamadoMaiorLucroDTO;
import Facts.Arch.ArchFacts.dto.dashboard.TarefaMaiorDespesaDTO;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kpis")
public class KPIController {
    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    @GetMapping("/{projetoId}/tarefa-maior-despesa")

    public ResponseEntity<TarefaMaiorDespesaDTO> getTarefaMaiorDespesa(
            @PathVariable UUID projetoId) {

        Tarefa tarefaMaiorDespesa = tarefaRepository
                .findTopByProjeto_IdProjetoOrderByDespesaDesc(projetoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhuma tarefa encontrada"));


        TarefaMaiorDespesaDTO dto = new TarefaMaiorDespesaDTO(
                tarefaMaiorDespesa.getIdTarefa(),
                tarefaMaiorDespesa.getTitulo(),
                tarefaMaiorDespesa.getDespesa(),
                tarefaMaiorDespesa.getStatus()
        );

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{projetoId}/chamado-maior-lucro")
    public ResponseEntity<ChamadoMaiorLucroDTO> getChamadoMaiorLucro(@PathVariable UUID projetoId) {
        Chamado chamadoMaiorLucro = chamadoRepository
                .findTopByProjeto_IdProjetoOrderByLucroDesc(projetoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhum chamado encontrado"));

        ChamadoMaiorLucroDTO dto = new ChamadoMaiorLucroDTO(
                chamadoMaiorLucro.getIdChamado(),
                chamadoMaiorLucro.getTitulo(),
                chamadoMaiorLucro.getLucro()
        );
        dto.setStatus(chamadoMaiorLucro.getStatus());
        return ResponseEntity.ok(dto);
    }
}
