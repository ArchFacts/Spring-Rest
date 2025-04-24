package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoRequestDTO;
import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.PropostaServico;
import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.ServicoRepository;
import Facts.Arch.ArchFacts.services.NegocioService;
import Facts.Arch.ArchFacts.services.ServicoService;
import Facts.Arch.ArchFacts.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class PropostaServicoMapper {
    @Autowired
    private ServicoService servicoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private NegocioService negocioService;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private NegocioRepository negocioRepository;

    public PropostaServico toEntity(PropostaServicoRequestDTO dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }

        PropostaServico propostaServico = new PropostaServico();
        Optional<Servico> possivelServico = servicoRepository.findById(dtoRequest.getIdServico());
        Usuario remetente = usuarioService.buscarPeloEmail(dtoRequest.getIdRemetente());
        Optional<Negocio> possivelDestinatario = negocioRepository.findById(dtoRequest.getIdDestinatario());

        if (possivelServico.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um serviço");
        }

        if (possivelDestinatario.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um negócio");
        }

        Servico servico = possivelServico.get();
        Negocio destinatario = possivelDestinatario.get();

        propostaServico.setServico(servico);
        propostaServico.setRemetente(remetente);
        propostaServico.setDestinatario(destinatario);

        return propostaServico;
    }

    public PropostaServicoResponseDTO toDto(PropostaServico propostaServico) {
        if (propostaServico == null) {
            return null;
        }

        PropostaServicoResponseDTO dto = new PropostaServicoResponseDTO();
        dto.setIdProposta(propostaServico.getProposta().getIdProposta().toString());
        dto.setFkRemetente(propostaServico.getRemetente().getEmail());
        dto.setFkDestinatario(propostaServico.getDestinatario().getIdNegocio().toString());
        dto.setIdServico(propostaServico.getServico().getIdServico().toString());
        dto.setFkNegocio(propostaServico.getDestinatario().getIdNegocio().toString());

        return dto;
    }
}
