package Facts.Arch.ArchFacts.services;
import Facts.Arch.ArchFacts.dto.mapper.ChamadoMapper;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
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

    public List<Chamado> buscarChamados (UUID idProjeto){
        List<Chamado> listaChamados = chamadoRepository.findByProjetoIdProjeto(idProjeto);

        if (listaChamados.isEmpty()) {
            throw new ListaVaziaException("Não foi possível identificar a sua lista");
        }
        return listaChamados;
    }
}