package Facts.Arch.ArchFacts.controller;

import Facts.Arch.ArchFacts.entity.Endereco;
import Facts.Arch.ArchFacts.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/enderecos")

public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<Endereco> verEndereco(@RequestParam String cep) {
        String url = "http://localhost:49152/enderecos?cep=" + cep;

        RestTemplate restTemplate = new RestTemplate(); // Para facilitar requisições externas
        // Pegando a resposta proveniente do método e convertendo para o objeto da API ArchFacts
        ResponseEntity<Endereco> resposta = restTemplate.getForEntity(url, Endereco.class);

        return ResponseEntity.ok(resposta.getBody());
    }
}
