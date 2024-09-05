package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.repository.NegocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/negocios")
public class NegocioController {
    @Autowired
    private NegocioRepository negocioRepository;
    private ResponseEntity<ResponseStatus> verificarEstadoNegocio (Negocio negocioSolicitado) {
        Boolean negocioExistente = this.negocioRepository.existsByCpfOrCnpj(negocioSolicitado.getCpf(),
                negocioSolicitado.getCnpj());

        if (negocioExistente) {
            Negocio negocioCadastrado = this.negocioRepository.findByCpfOrCnpj(negocioSolicitado.getCpf(),
                    negocioSolicitado.getCnpj());

            if (negocioCadastrado.getAtivado()) { // Conta existe e está ativada
                return ResponseEntity.status(409).build();
            } else {
                return ResponseEntity.status(200).build(); // Conta existe e está desativada
                // Implementar método para recuperação de conta
            }
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Negocio> cadastrarNegocio(@RequestBody Negocio negocioSolicitado) {
        negocioSolicitado.setId(null);

        if (verificarEstadoNegocio(negocioSolicitado).equals(ResponseEntity.status(404).build())) {
            negocioSolicitado.setAtivado(Boolean.TRUE);
            negocioSolicitado.setCodigoNegocio(UUID.randomUUID().toString());
            return ResponseEntity.status(201).body(this.negocioRepository.save(negocioSolicitado));
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<Negocio>> listarNegocios() {
        List<Negocio> todosNegocios = this.negocioRepository.findAll();

        if (todosNegocios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(todosNegocios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Negocio> atualizarNegocio(@PathVariable UUID id, @RequestBody Negocio negocioSolicitado){
        if (this.negocioRepository.existsById(id)) {
            negocioSolicitado.setId(id);
            Negocio negocioAtualizado = this.negocioRepository.save(negocioSolicitado);
            return ResponseEntity.status(204).body(negocioAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deletarNegocio(@PathVariable UUID id){
        if (this.negocioRepository.existsById(id)){
            this.negocioRepository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }
}
