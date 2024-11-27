package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.proposta.PropostaRequestDTO;
import Facts.Arch.ArchFacts.dto.proposta.PropostaResponseDTO;
import Facts.Arch.ArchFacts.entities.Endereco;
import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.services.EnderecoService;
import Facts.Arch.ArchFacts.services.NegocioService;
import Facts.Arch.ArchFacts.services.PropostaService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropostaMapper {
    @Autowired
    UsuarioLogadoService usuarioLogadoService;
    @Autowired
    NegocioService negocioService;
    @Autowired
    PropostaService propostaService;
    @Autowired
    EnderecoService enderecoService;
    public Proposta toEntity(PropostaRequestDTO dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }

        Proposta proposta = new Proposta();
        proposta.setTitulo(dtoRequest.getTitulo());
        proposta.setCep(dtoRequest.getCep());
        proposta.setEndereco(dtoRequest.getEndereco());
        proposta.setNumero(dtoRequest.getNumero());
        proposta.setComplemento(dtoRequest.getComplemento());
        proposta.setDescricao(dtoRequest.getDescricao());

        return proposta;
    }

    public PropostaResponseDTO toDto (Proposta proposta) {
        if (proposta == null) {
            return null;
        }

        PropostaResponseDTO dto = new PropostaResponseDTO();
        dto.setEmpresa(proposta.getDestinatario());
        dto.setSolicitante(proposta.getRemetente());
        dto.setEmailEmpresa(negocioService.encontrarDonoNegocio(proposta.getDestinatario().getIdNegocio()).getEmail());
        dto.setEmailSolicitante(proposta.getRemetente().getEmail());
        dto.setCep(proposta.getCep());
        dto.setEndereco(proposta.getEndereco());

        Endereco endereco = enderecoService.consultarEndereco(proposta.getCep());
        dto.setBairro(endereco.getBairro());

        dto.setNumero(proposta.getNumero());
        dto.setComplemento(proposta.getComplemento());
        dto.setData(proposta.getDataEntrega());

        return dto;
    }
}
