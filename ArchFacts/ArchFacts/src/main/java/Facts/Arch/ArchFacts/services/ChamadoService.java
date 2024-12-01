package Facts.Arch.ArchFacts.services;
import Facts.Arch.ArchFacts.dto.mapper.ChamadoMapper;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChamadoService {

    private ChamadoRepository chamadoRepository;
    private ProjetoRepository projetoRepository;
    private ChamadoMapper chamadoMapper;

    public Chamado criarChamado (UUID idProjeto, Chamado chamado) {
        Optional<Projeto> possivelProjeto = projetoRepository.findById(idProjeto);

        if (possivelProjeto.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encotrar o projeto");
        }

        Projeto projeto = possivelProjeto.get();
        chamado.setProjeto(projeto);
        chamado.setAbertura(LocalDateTime.now());

        return chamadoRepository.save(chamado);
    }
}