package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.PropostaServicoMapper;
import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoRequestDTO;
import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoResponseDTO;
import Facts.Arch.ArchFacts.entities.PropostaServico;
import Facts.Arch.ArchFacts.services.PropostaServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/propostaServicos")
public class PropostaServicoController {
    @Autowired
    private PropostaServicoService propostaServicoService;
    @Autowired
    private PropostaServicoMapper propostaServicoMapper;
    @PostMapping
    public ResponseEntity<PropostaServicoResponseDTO> cadastrarPropostaServico(@RequestBody PropostaServicoRequestDTO dto) {
        PropostaServico propostaServico = propostaServicoMapper.toEntity(dto);
        PropostaServico propostaServicoSalvo = propostaServicoService.cadastrarPropostaServico(propostaServico);
        PropostaServicoResponseDTO resposta = propostaServicoMapper.toDto(propostaServicoSalvo);
        return ResponseEntity.status(200).body(resposta);
    }
}
