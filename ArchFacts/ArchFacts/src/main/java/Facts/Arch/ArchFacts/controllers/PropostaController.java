package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.NegocioMapper;
import Facts.Arch.ArchFacts.dto.mapper.PropostaMapper;
import Facts.Arch.ArchFacts.dto.proposta.PropostaRequestDTO;
import Facts.Arch.ArchFacts.dto.proposta.PropostaResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.services.NegocioService;
import Facts.Arch.ArchFacts.services.PropostaService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
    @Autowired
    private PropostaService propostaService;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private PropostaMapper propostaMapper;


    @GetMapping
    ResponseEntity<List<Proposta>> buscarPropostas() {
        List<Proposta> listaPropostas = propostaService.buscarPropostas
                (usuarioLogadoService.obterNegocio().getIdNegocio());
        return ResponseEntity.status(200).body(listaPropostas);
    }

    @GetMapping("/buscarNegocioProposta/{codigo}")
    ResponseEntity<Negocio> buscarNegocio (@PathVariable String codNegocio) {
        Negocio negocio = propostaService.solicitacaoEnvioPropostaNegocio(codNegocio);
        return ResponseEntity.status(200).body(negocio);
    }

    @PostMapping("/{codigoNegocio}/{nomeNegocio}")
    ResponseEntity<PropostaResponseDTO> cadastrarProposta(@RequestBody PropostaRequestDTO dto,
                                               @PathVariable String codigoNegocio) {
        Proposta proposta = propostaMapper.toEntity(dto);
        PropostaResponseDTO resposta = propostaMapper.toDto(propostaService.criarProposta(proposta, codigoNegocio));

        return ResponseEntity.status(200).body(resposta);
    }

//    @GetMapping("/enviar-proposta1/{codigo}/{nome}")
//    ResponseEntity<PropostaRequestDTO> buscarProposta(@PathVariable String codNegocio,
//                                                      @PathVariable String nomeNegocio) {
//        Negocio negocio = propostaService.solicitacaoEnvioPropostaNegocio(codNegocio);
//        PropostaRequestDTO resposta = PropostaMapper
//
//    }

}
