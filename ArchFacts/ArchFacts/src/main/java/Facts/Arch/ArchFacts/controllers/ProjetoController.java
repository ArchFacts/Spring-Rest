package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.ProjetoMapper;
import Facts.Arch.ArchFacts.dto.projeto.ProjetoResponseDTO;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.services.ProjetoService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private ProjetoService projetoService;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @PostMapping("/aceitar")
    public ResponseEntity<ProjetoResponseDTO> criarProjeto (@RequestBody UUID idProposta) {
        ProjetoResponseDTO resposta = ProjetoMapper.toDto(projetoService.criarProjeto(idProposta));
        return ResponseEntity.status(201).body(resposta);
    }

    @GetMapping()
    public ResponseEntity<List<Projeto>> listarProjetosNegocio() {
        UUID idNegocio = usuarioLogadoService.obterNegocio().getIdNegocio();
        List<Projeto> listaProjetos = projetoRepository.findByNegocio_IdNegocio(idNegocio);
        return ResponseEntity.status(200).body(listaProjetos);
    }

    @GetMapping("/beneficiario/{nomeEmpresa}")
    public ResponseEntity<List<Projeto>> listarProjetosBeneficiario(@PathVariable String nomeEmpresa){
        String email = usuarioLogadoService.obterSessao().getEmail();
        List<Projeto> listaProjetos =
                projetoRepository.findByDestinatario_EmailAndNegocio_NomeContainingIgnoreCase(email, nomeEmpresa);
        return ResponseEntity.status(200).body(listaProjetos);
    }

    @GetMapping("/nome/{idProjeto}")
    public ResponseEntity<String> encontrarProjeto (@PathVariable UUID idProjeto) {
        Projeto projeto = projetoService.encontrarProjetoPeloId(idProjeto);

        return ResponseEntity.status(200).body(projeto.getNome());
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Projeto>> encontrarTodosProjetos() {
        List<Projeto> listaProjetos = projetoService.encontrarTodosProjetosNegocio();

        return ResponseEntity.status(200).body(listaProjetos);
    }
}
