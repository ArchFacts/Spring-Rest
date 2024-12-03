package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.dashboard.ResumoFinanceiroDTO;
import Facts.Arch.ArchFacts.entities.Financeiro;
import Facts.Arch.ArchFacts.repositories.FinanceiroRepository;
import Facts.Arch.ArchFacts.services.FinanceiroService;
import Facts.Arch.ArchFacts.services.ProjetoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/dashboards")
public class DashboardController {
    @Autowired
    private FinanceiroRepository financeiroRepository;
    @GetMapping("/{projetoId}/resumo-financeiro")
    public ResponseEntity<ResumoFinanceiroDTO> getResumoFinanceiro(
            @PathVariable UUID projetoId
    ) {
        Financeiro financeiro = financeiroRepository
                .findFirstByProjeto_IdProjetoOrderByDataCriacaoDesc(projetoId)
                .orElseThrow(() -> new RuntimeException("Dados financeiros não encontrados"));

        ResumoFinanceiroDTO resumo = new ResumoFinanceiroDTO(
                financeiro.getLucroTotal(),
                financeiro.getDespesaTotal(),
                financeiro.getReceita(),
                financeiro.getDataCriacao()
        );
        return ResponseEntity.ok(resumo);
    }
}
