package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.dto.observer.DadosEntidadeDTO;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import Facts.Arch.ArchFacts.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class EventoObserver implements Observer {
    @Autowired
    EventoService eventoService;
    @Override
    public void atualizar(Object entidade) {
        DadosEntidadeDTO dto = DadosEntidadeDTO.setarDadosObserver(entidade);

        if (dto.getDataTermino() != null) {
            long diasRestantes = LocalDateTime.now().until(dto.getDataTermino(), ChronoUnit.DAYS);

            if (diasRestantes <= 5) {
                Prioridade prioridade = Prioridade.definirPrioridadeEvento((int) diasRestantes);

                eventoService.criarEvento(
                        dto.getTipo(),
                        prioridade,
                        dto.getDescricao(),
                        dto.getDataInicio(),
                        dto.getDataTermino(),
                        dto.getStatus(),
                        dto.getProjeto(),
                        dto.getNegocio()
                );
            }
        }
    }
}
