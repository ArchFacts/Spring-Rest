package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.propostaServico.PropostaServicoRequestDTO;
import Facts.Arch.ArchFacts.dto.propostaServico.PropostasAbertasResumoRespostaDTO;
import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PropostaServicoService {
    @Autowired
    private PropostaServicoRepository propostaServicoRepository;
    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NegocioRepository negocioRepository;


    public PropostaServico cadastrarPropostaServico(PropostaServico propostaServico) {
        Usuario usuario = propostaServico.getRemetente();

        Negocio destinatario = propostaServico.getDestinatario();

        Servico servico = propostaServico.getServico();

        PropostaServico propostaServicoEnvio = new PropostaServico();
        propostaServicoEnvio.setIdPropostaServico(null);
        propostaServicoEnvio.setServico(servico);
        propostaServicoEnvio.setRemetente(usuario);

        Optional<Proposta> possivelProposta = propostaRepository.findTopByRemetente_IdUsuarioOrderByDataEnvioDesc(usuario.getIdUsuario());

        if (possivelProposta.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar uma proposta");
        }
        Proposta proposta = possivelProposta.get();


        propostaServicoEnvio.setProposta(proposta);
        propostaServicoEnvio.setDestinatario(destinatario);
        propostaServicoEnvio.setDataCriacao(LocalDateTime.now());

        return propostaServicoRepository.save(propostaServicoEnvio);
    }

//    public List<> propostasAbertas() {
//        PropostasAbertasResumoRespostaDTO dto = new PropostasAbertasResumoRespostaDTO();
//        return null;
//    }
}
