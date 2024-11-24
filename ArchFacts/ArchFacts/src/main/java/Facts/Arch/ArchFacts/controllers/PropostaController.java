package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.services.PropostaService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/propostas")
public class PropostaController {
    @Autowired
    private PropostaService propostaService;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;
    @GetMapping
    ResponseEntity<List<Proposta>> buscarPropostas() {
        List<Proposta> listaPropostas = propostaService.buscarPropostas
                (usuarioLogadoService.obterNegocio().getIdNegocio());
        return ResponseEntity.status(200).body(listaPropostas);
    }
}
