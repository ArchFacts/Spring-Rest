package Facts.Arch.ArchFacts.services;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

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
                             Negocio negocio,
                             UUID idEntidade) {
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
        evento.setIdEntidade(idEntidade);

        eventoRepository.save(evento);
    }

    public Boolean verificarIdEvento(UUID idEntidade) {
        if (idEntidade == null) {
            throw new EntidadeInexistenteException("Não foi possível encontrar algo relacionado a esse evento");
        }

        return eventoRepository.existsByIdEntidade(idEntidade);
    }
}
