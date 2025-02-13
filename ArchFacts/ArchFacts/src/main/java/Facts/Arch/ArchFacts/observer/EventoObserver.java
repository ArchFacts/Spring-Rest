package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.observer.DadosEntidadeDTO;
import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EventoExistenteException;
import Facts.Arch.ArchFacts.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class EventoObserver implements Observer {
    @Autowired
    private EventoService eventoService;

    @Autowired EventoObserver(Subject subject) {
        subject.adicionar(this);
    }
    @Override
    public void atualizar(Object entidade) {
        DadosEntidadeDTO dto = DadosEntidadeDTO.setarDadosObserver(entidade);

        if (dto.getDataTermino() != null) {
            long diasRestantes = LocalDateTime.now().until(dto.getDataTermino(), ChronoUnit.DAYS);
            UUID idEntidade = null;

            if (entidade instanceof Tarefa) {
                idEntidade = ((Tarefa) entidade).getIdTarefa();
            } else if (entidade instanceof Chamado) {
                idEntidade = ((Chamado) entidade).getIdChamado();
            } else if (entidade instanceof Projeto) {
                idEntidade = ((Projeto) entidade).getIdProjeto();
            }

            if (diasRestantes <= 5 && diasRestantes >= 0) {

                if (idEntidade != null && !eventoService.verificarIdEvento(idEntidade)) {

                    Prioridade prioridade = Prioridade.definirPrioridadeEvento((int) diasRestantes);

                    eventoService.criarEvento(
                            dto.getTipo(),
                            prioridade,
                            dto.getDescricao(),
                            dto.getDataInicio(),
                            dto.getDataTermino(),
                            dto.getStatus(),
                            dto.getProjeto(),
                            dto.getNegocio(),
                            idEntidade
                    );
                } else {
                    throw new EventoExistenteException("Este evento já está registrado no banco de dados");
                }
            } else if (diasRestantes <= -3) {
                eventoService.removerEvento(idEntidade);
            }
        } else {
            throw new EntidadeInexistenteException("Não foi possível encontrar um evento");
        }
    }
}
