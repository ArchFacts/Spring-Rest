package Facts.Arch.ArchFacts.controllers;

import Facts.Arch.ArchFacts.dto.mapper.NegocioMapper;
import Facts.Arch.ArchFacts.dto.negocio.NegocioRequestDTO;
import Facts.Arch.ArchFacts.dto.negocio.NegocioResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.services.EnderecoService;
import Facts.Arch.ArchFacts.services.NegocioService;
import Facts.Arch.ArchFacts.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/negocios")
public class NegocioController {
    @Autowired
    private NegocioService negocioService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private NegocioMapper negocioMapper;

    @GetMapping
    public ResponseEntity<List<Negocio>> listar() {
        List<Negocio> negociosEncontrados = this.negocioService.listar();

        if (negociosEncontrados.isEmpty()) {
            return ResponseEntity.status(204).body(negociosEncontrados);
        }

        return ResponseEntity.status(200).body(negociosEncontrados);
    }
    @PostMapping
    public ResponseEntity<NegocioResponseDTO> cadastrar (@Valid @RequestBody NegocioRequestDTO dto) {
        Negocio negocio = negocioMapper.toEntity(dto);
        NegocioResponseDTO resposta = NegocioMapper.toDto(negocioService.criarNegocio(negocio));
        return ResponseEntity.status(200).body(resposta);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Negocio> atualizarNegocio(@PathVariable UUID id, @RequestBody Negocio negocioSolicitado){
//
//    }

//    @DeleteMapping ("/{idNegocio}/{idUsuario}")
//    public ResponseEntity<Void> deletarNegocio(@PathVariable UUID idNegocio, @PathVariable UUID idUsuario){
//        Optional<Usuario> possivelUsuario = this.usuarioRepository.findById(idUsuario);
//        if (possivelUsuario.isEmpty()) {
//            return ResponseEntity.status(204).build();
//        }
//
//        if (this.negocioRepository.existsById(idNegocio)){
//            Usuario usuario = possivelUsuario.get();
//
//            if (!usuario.getRole().equals(Role.ADMINISTRADOR)) { // Não permitir excluir se ele não for adm
//                return ResponseEntity.status(401).build(); // Não Autorizado
//            }
//
//            this.negocioRepository.deleteById(idNegocio);
//            return ResponseEntity.status(204).build();
//        }
//        return ResponseEntity.status(404).build();
//    }
}
