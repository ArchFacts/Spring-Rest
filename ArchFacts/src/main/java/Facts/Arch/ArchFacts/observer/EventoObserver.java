package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.observer.DadosEntidadeDTO;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.exceptions.CamposInvalidosException;
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

    @Autowired
    EventoObserver(Subject subject) {
        subject.adicionar(this);
    }

    @Override
    public void atualizar(Object entidade) {
        DadosEntidadeDTO dto = DadosEntidadeDTO.setarDadosObserver(entidade);

        if (dto.getDataTermino() != null) {
            long diasRestantes = ChronoUnit.DAYS.between(LocalDateTime.now().toLocalDate(), dto.getDataTermino().toLocalDate());
            UUID idEntidade = null;

            if (entidade instanceof Tarefa) {
                idEntidade = ((Tarefa) entidade).getIdTarefa();
            } else if (entidade instanceof Chamado) {
                idEntidade = ((Chamado) entidade).getIdChamado();
            } else if (entidade instanceof Projeto) {
                idEntidade = ((Projeto) entidade).getIdProjeto();
            }
            if (idEntidade != null) {
                if (diasRestantes < 0) {
                    Boolean eventoRemovido = eventoService.removerEvento(idEntidade);

                    if (eventoRemovido) {
                        System.out.println("O evento foi removido para o ID" + idEntidade);
                    } else {
                        System.out.println("Nenhum evento para remover de ID" + idEntidade);
                    }
                }
            } if (diasRestantes <= 5) {
                try {
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
                        throw new EventoExistenteException(
                                "Este evento já está registrado no banco de dados com o ID" + idEntidade);
                    }
                } catch (Exception e) {
                    System.err.println("Erro ao processar entidade ID " + idEntidade + ": " + e.getMessage());
                }
            } else {
                throw new CamposInvalidosException("O evento não tem data de término");
            }
        }
    }
}
