package Facts.Arch.ArchFacts.integration;

import Facts.Arch.ArchFacts.entities.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cep-integration", url = "https://viacep.com.br/ws/")
public interface CepIntegration {
    @GetMapping("/{cep}/json/")
    Endereco buscarEndereco(@PathVariable String cep);
}
