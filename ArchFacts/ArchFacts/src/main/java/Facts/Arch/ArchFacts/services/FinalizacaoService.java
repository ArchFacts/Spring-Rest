package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import Facts.Arch.ArchFacts.repositories.TarefaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FinalizacaoService {
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private TarefaRepository tarefaRepository;

    @Transactional
    public void finalizarChamado (UUID idChamado) {
        Chamado chamado = chamadoRepository.findById(idChamado)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Chamado não encontrado"));
        chamado.setStatus(Status.FECHADO);
        chamadoRepository.save(chamado);
    }

    @Transactional
    public void finalizarProjeto (UUID idProjeto) {
        Projeto projeto = projetoRepository.findById(idProjeto)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Projeto não encontrado"));
        projeto.setStatus(Status.FECHADO);
        projetoRepository.save(projeto);
    }

    @Transactional
    public void finalizarTarefa (UUID idTarefa) {
        Tarefa tarefa = tarefaRepository.findById(idTarefa)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Tarefa não encontrado"));
        tarefa.setStatus(Status.FECHADO);
        tarefaRepository.save(tarefa);
    }
}
