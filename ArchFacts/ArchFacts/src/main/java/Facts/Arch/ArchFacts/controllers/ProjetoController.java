package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.ProjetoMapper;
import Facts.Arch.ArchFacts.dto.projeto.ProjetoRequestDTO;
import Facts.Arch.ArchFacts.dto.projeto.ProjetoResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
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
    public ResponseEntity<List<Projeto>> listarDadosNegocio() {
        UUID idNegocio = usuarioLogadoService.obterNegocio().getIdNegocio();
        List<Projeto> listaProjetos = projetoRepository.findByNegocio_IdNegocio(idNegocio);
        return ResponseEntity.status(200).body(listaProjetos);
    }

//    @PostMapping ("")
//    public ResponseEntity<Projeto> cadastrarProjeto(@PathVariable UUID idDestinatario,
//                                                    @PathVariable UUID idNegocio,
//                                                    @RequestBody Projeto projetoSolicitado) {
//
//        Optional<Usuario> possivelDestinatario = usuarioRepository.findById(idDestinatario);
//        Optional<Negocio> possivelNegocio = negocioRepository.findById(idNegocio);
//
//        if (possivelDestinatario.isEmpty() || possivelNegocio.isEmpty()) {
//            return ResponseEntity.status(404).build();
//        }
//
//        Usuario destinatario = possivelDestinatario.get();
//        Negocio negocio = possivelNegocio.get();
//
//        EstrategiaProjeto estrategiaProjeto = new EstrategiaProjeto(destinatario, negocio);
//        FactoryCampos factoryCampos = new FactoryCampos(estrategiaProjeto);
//        factoryCampos.configurarCampos(projetoSolicitado);

//        projetoSolicitado.setId(null);
//        projetoSolicitado.setStatus(Status.ABERTO);
//        projetoSolicitado.setDestinatario(destinatario);
//        projetoSolicitado.setDataInicio(LocalDate.now());
//        projetoSolicitado.setNegocio(negocio);

//        return ResponseEntity.status(201).body(projetoRepository.save(projetoSolicitado));
//    }

//    @GetMapping
//    public ResponseEntity<List<Projeto>> listarProjetos() {
//        List<Projeto> todosProjetos = projetoRepository.findAll();
//
//        if (todosProjetos.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(200).body(todosProjetos);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Projeto> atualizarProjeto(@PathVariable UUID id, @RequestBody Projeto projetoSolicitado) {
//        if (this.projetoRepository.existsById(id)) {
//            projetoSolicitado.setIdProjeto(id);
//            Projeto projetoAtualizado = this.projetoRepository.save(projetoSolicitado);
//            return ResponseEntity.status(200).body(projetoAtualizado);
//        }
//        return ResponseEntity.status(404).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletarProjeto(@PathVariable UUID id) {
//        if (this.projetoRepository.existsById(id)) {
//            this.projetoRepository.deleteById(id);
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(404).build();
//    }
}
