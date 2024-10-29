package Facts.Arch.ArchFacts.observer;

import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.enums.Tipo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
@Service
public class Notificador implements GerenciadorEvento {
    @Override
    public void atualizar(Evento evento) {
        Long diasRestantes = calcularDiasRestantes(evento);

    }
    public Long calcularDiasRestantes(Evento evento) {
        LocalDateTime dataHoje = LocalDateTime.now();
        LocalDateTime prazoFinal = evento.getDataTermino();

        Long diasRestantes = ChronoUnit.DAYS.between(dataHoje, prazoFinal);
        return diasRestantes;
    }

    public Prioridade calcularPrioridade(Evento evento) {
        Long diasRestantes = calcularDiasRestantes(evento);
        Prioridade definirPrioridade = null;
        if (diasRestantes <= 7 && diasRestantes >= 5) {
            definirPrioridade = Prioridade.BAIXA;
        } else if (diasRestantes <= 4) {
            definirPrioridade = Prioridade.MEDIA;
        } else {
            definirPrioridade = Prioridade.ALTA;
        }
        return definirPrioridade;
    }

//    public Tipo definirTipo(Object objetoGenerico) {
//        Tipo tipoDefinido = null;
//        if (objetoGenerico instanceof Projeto) {
//            tipoDefinido = Tipo.PROJETO;
//        } else if (objetoGenerico instanceof Chamado) {
//            tipoDefinido = Tipo.CHAMADO;
//        } else if (objetoGenerico instanceof Tarefa) {
//            tipoDefinido = Tipo.TAREFA;
//        }
//        return tipoDefinido;
//    }
}
