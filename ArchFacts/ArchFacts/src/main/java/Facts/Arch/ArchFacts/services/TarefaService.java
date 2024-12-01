package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import Facts.Arch.ArchFacts.repositories.TarefaRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaTarefa;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepository tarefaRepository;
    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Tarefa> buscarTarefas(UUID idProjeto) {
        List<Tarefa> listaTarefas = this.tarefaRepository.findByProjetoIdProjeto(idProjeto);

        if (listaTarefas.isEmpty()) {
            throw new ListaVaziaException("Não foi possível identificar a sua lista");
        }

        return listaTarefas;
    }

    public Tarefa criarTarefa (UUID idProjeto, Tarefa tarefaCadastro) {
        Optional<Projeto> possivelProjeto = projetoRepository.findById(idProjeto);

        if (possivelProjeto.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encotrar o projeto");
        }

        Projeto projeto = possivelProjeto.get();

        EstrategiaTarefa estrategiaTarefa = new EstrategiaTarefa();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaTarefa);
        factoryCampos.configurarCampos(tarefaCadastro);

        tarefaCadastro.setProjeto(projeto);

        return tarefaRepository.save(tarefaCadastro);
    }
}
