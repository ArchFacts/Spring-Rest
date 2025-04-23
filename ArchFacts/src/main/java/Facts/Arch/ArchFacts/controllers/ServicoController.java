package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.ServicoMapper;
import Facts.Arch.ArchFacts.dto.negocio.NegocioResponseDTO;
import Facts.Arch.ArchFacts.dto.servico.ServicoRequestDTO;
import Facts.Arch.ArchFacts.dto.servico.ServicoResponseDTO;
import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.services.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @Autowired
    private ServicoMapper servicoMapper;

    @PostMapping
    ResponseEntity<ServicoResponseDTO> cadastrarServico(@RequestBody ServicoRequestDTO dto) {
        Servico servico = servicoMapper.toEntity(dto);
        ServicoResponseDTO resposta = servicoMapper.toDto(servicoService.cadastrarServico(servico));
        return ResponseEntity.status(200).body(resposta);
    }

    @GetMapping("/{codigoNegocio}")
    ResponseEntity<List<Servico>> obterServicosNegocio(@PathVariable String codigoNegocio) {
        List<Servico> listaServicos = this.servicoService.obterServicosDoNegocio(codigoNegocio);
        return ResponseEntity.status(200).body(listaServicos);
    }

}
