package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.observer.Subject;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import Facts.Arch.ArchFacts.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoramentoService {
    @Autowired
    TarefaRepository tarefaRepository;
    @Autowired
    ChamadoRepository chamadoRepository;
    @Autowired
    ProjetoRepository projetoRepository;

    @Autowired
    private Subject subject;

    @Scheduled(fixedRate = 10000)
    public void monitoramentoEntidades() {
        List<Tarefa> listaTarefas = tarefaRepository.findAll();
        System.out.println("VERIFICANDO ENTIDADES");
        tarefaRepository.findAll().forEach(subject::notificar);
        chamadoRepository.findAll().forEach(subject::notificar);
        projetoRepository.findAll().forEach(subject::notificar);
    }
}
