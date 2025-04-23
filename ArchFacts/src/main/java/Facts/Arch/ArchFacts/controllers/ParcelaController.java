package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.parcela.ParcelaRequestDTO;
import Facts.Arch.ArchFacts.entities.Parcela;
import Facts.Arch.ArchFacts.services.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/parcelas")
public class ParcelaController {
    @Autowired
    private ParcelaService parcelaService;
    @PostMapping("/{idProjeto}")
    public ResponseEntity<List<Parcela>> criarParcelas(
            @PathVariable UUID idProjeto,
            @RequestBody ParcelaRequestDTO dto){
        List<Parcela> listaParcelas = parcelaService.definirParcelas(dto, idProjeto);
        return ResponseEntity.status(200).build();
    }
}
