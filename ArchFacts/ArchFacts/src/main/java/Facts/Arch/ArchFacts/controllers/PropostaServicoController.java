package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.PropostaServicoMapper;
import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoRequestDTO;
import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoResponseDTO;
import Facts.Arch.ArchFacts.dto.propostaServico.ServicoEmailDTO;
import Facts.Arch.ArchFacts.entities.PropostaServico;
import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.repositories.PropostaServicoRepository;
import Facts.Arch.ArchFacts.services.PropostaServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/propostaServicos")
public class PropostaServicoController {
    @Autowired
    private PropostaServicoService propostaServicoService;
    @Autowired
    private PropostaServicoMapper propostaServicoMapper;
    @Autowired
    PropostaServicoRepository propostaServicoRepository;
    @PostMapping
    public ResponseEntity<PropostaServicoResponseDTO> cadastrarPropostaServico(@RequestBody PropostaServicoRequestDTO dto) {
        PropostaServico propostaServico = propostaServicoMapper.toEntity(dto);
        PropostaServico propostaServicoSalvo = propostaServicoService.cadastrarPropostaServico(propostaServico);
        PropostaServicoResponseDTO resposta = propostaServicoMapper.toDto(propostaServicoSalvo);
        return ResponseEntity.status(200).body(resposta);
    }

    @PostMapping("/buscar")
    public ResponseEntity<List<ServicoEmailDTO>> buscarServicosProposta(@RequestBody UUID idProposta) {
        List<ServicoEmailDTO> servicos = this.propostaServicoRepository.findServicoAndEmailByProposta(idProposta);

        if (servicos.isEmpty()) {
            throw new ListaVaziaException("Não foi possível encontrar serviços na sua proposta");
        }

        return ResponseEntity.status(200).body(servicos);
    }
}
