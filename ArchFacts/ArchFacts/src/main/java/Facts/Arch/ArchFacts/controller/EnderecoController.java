package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Endereco;
import Facts.Arch.ArchFacts.repository.EnderecoRepository;
import Facts.Arch.ArchFacts.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/enderecos")

public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<Endereco> consultarEndereco(@RequestParam String cep) {
        Endereco enderecoEncontrado = this.enderecoService.consultarEndereco(cep);
        return ResponseEntity.status(200).body(enderecoEncontrado);
    }

//    @GetMapping("/ordenacao")
//    public ResponseEntity<Endereco[]> enderecosOrdenados(){
//        Endereco[] enderecos = enderecoService.findAll().toArray(new Endereco[0]);
//        if(enderecos.length == 0){
//            return ResponseEntity.status(204).build();
//        }
//
//        for(int i = 0; i < enderecos.length-1; i++){
//            int minimo = i;
//            for(int j = i+1; j < enderecos.length;j++){
//                if(enderecos[j].getCidade().compareToIgnoreCase(enderecos[minimo].getCidade()) < 0){
//                    minimo=j;
//                }
//            }
//            Endereco aux = enderecos[minimo];
//            enderecos[minimo] = enderecos[i];
//            enderecos[i] = aux;
//        }
//        return ResponseEntity.status(200).body(enderecos);
//    }
}
