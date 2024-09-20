package Facts.Arch.ArchFacts.service;

import Facts.Arch.ArchFacts.entity.Endereco;
import Facts.Arch.ArchFacts.exception.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exception.FalhaComunicacaoCepException;
import Facts.Arch.ArchFacts.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco consultarEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Endereco> resposta = restTemplate.getForEntity(url, Endereco.class);

            if (resposta.getStatusCode().equals(HttpStatus.OK)) {
                return resposta.getBody();
            } else {
                throw new EntidadeInexistenteException("Não foi possível encontrar o CEP" + cep);
            }

        } catch (RestClientException e) {
            throw new FalhaComunicacaoCepException("Erro ao se comunicar com API de CEP" + e.getMessage());
        }
    }
}
