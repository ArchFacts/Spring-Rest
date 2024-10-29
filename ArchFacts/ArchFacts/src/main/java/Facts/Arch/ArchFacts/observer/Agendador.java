package Facts.Arch.ArchFacts.observer;


import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enums.Tipo;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Agendador {
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private Notificador notificador;
    public void verificarProximidade(List<Projeto> projetos) {
        LocalDateTime dataHoje = LocalDateTime.now();

        for (Projeto projeto: projetos) {
            LocalDateTime dataEntregaProjeto = projeto.getDataEntrega();

            if (dataEntregaProjeto.minusDays(3).isBefore(dataHoje)) {
                Evento evento = new Evento();
                evento.setIdEvento(UUID.randomUUID());
                evento.setDataInicio(projeto.getDataInicio());
                evento.setDataTermino(projeto.getDataEntrega());
                evento.setTipo(Tipo.PROJETO);
                evento.setDescricao(projeto.getDescricao());
                evento.setStatus(projeto.getStatus());

                eventoRepository.save(evento);
            }
        }
    }

    public static void notificarObservers(List<GerenciadorEvento> eventos) {

    }
}
