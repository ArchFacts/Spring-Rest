package Facts.Arch.ArchFacts.services;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public void criarEvento (Tipo tipo,
                             Prioridade prioridade,
                             String descricao,
                             LocalDateTime dataInicio,
                             LocalDateTime dataTermino,
                             Status status,
                             Projeto projeto,
                             Negocio negocio) {
        Evento evento = new Evento();
        evento.setDataInicio(dataInicio);
        evento.setDataTermino(dataTermino);
        evento.setDataCriacao(LocalDateTime.now());
        evento.setTipo(tipo);
        evento.setPrioridade(prioridade);
        evento.setDescricao(descricao);
        evento.setStatus(status);
        evento.setProjeto(projeto);
        evento.setNegocio(negocio);

        eventoRepository.save(evento);
    }
}
