package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.proposta.PropostaRequestDTO;
import Facts.Arch.ArchFacts.dto.proposta.PropostaResponseDTO;
import Facts.Arch.ArchFacts.entities.Proposta;
import Facts.Arch.ArchFacts.services.NegocioService;
import Facts.Arch.ArchFacts.services.PropostaService;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;

public class PropostaMapper {
    @Autowired
    UsuarioLogadoService usuarioLogadoService;
    @Autowired
    NegocioService negocioService;

    @Autowired
    PropostaService propostaService;
    public Proposta toEntity(PropostaRequestDTO dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }

        Proposta proposta = new Proposta();
        proposta.setConteudo(dtoRequest.getDescricao());
        proposta.setDataEnvio((dtoRequest.getData()));
        proposta.setUsuario(usuarioLogadoService.obterSessao());
//        proposta.setNegocio(propostaService.buscarSolicitante());

        return proposta;
    }

    public PropostaResponseDTO toDto (Proposta proposta) {
        if (proposta == null) {
            return null;
        }

        PropostaResponseDTO dto = new PropostaResponseDTO();

        dto.setEmpresa(propostaService.buscarEmpresa());
        return null;
    }
}
