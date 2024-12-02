package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.chamado.ChamadoRequestDTO;
import Facts.Arch.ArchFacts.dto.chamado.ChamadoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.ChamadoMapper;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.services.ChamadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/chamados")
public class ChamadoController {

    @Autowired
    private ChamadoMapper chamadoMapper;
    @Autowired
    private ChamadoService chamadoService;
    @Autowired
    private ChamadoRepository chamadoRepository;

    @PostMapping("/{idProjeto}")
    public ResponseEntity<ChamadoResponseDTO> cadastrar(@Valid @RequestBody ChamadoRequestDTO dto, @PathVariable UUID idProjeto) {
        Chamado chamado = chamadoMapper.toEntity(dto);
        ChamadoResponseDTO resposta = chamadoMapper.toDto(chamadoService.criarChamado(idProjeto, chamado));
        return ResponseEntity.status(200).body(resposta);
    }

    @GetMapping("/{idProjeto}")
    public ResponseEntity<List<Chamado>> listarChamados(@PathVariable UUID idProjeto) {
        List<Chamado> listaChamados = this.chamadoService.buscarChamados(idProjeto);
        return ResponseEntity.status(200).body(listaChamados);
    }

//    @PutMapping()
//    public ResponseEntity<>
}
