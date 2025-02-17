package Facts.Arch.ArchFacts.services;
import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    @Autowired
    private EventoMapper eventoMapper;

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

    @Transactional
    public void removerEvento(UUID idEntidade) {
        if (idEntidade == null) {
            throw new EntidadeInexistenteException("Não foi possível encontrar algo relacionado a esse evento");
        }

        eventoRepository.deleteByIdEntidade(idEntidade);
    }

    public List<EventoResponseDTO> encontrarEventosNegocio() {
        UUID idNegocio = usuarioLogadoService.obterNegocio().getIdNegocio();
        List<Evento> listaEventos = eventoRepository.findByNegocio_IdNegocio(idNegocio);

        if (listaEventos.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar eventos");
        }

        return listaEventos.stream()
                .map(eventoMapper::toDto)
                .collect(Collectors.toList());
    }
}
