package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.exceptions.ListaVaziaException;
import Facts.Arch.ArchFacts.observer.Notificador;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService {
    @Autowired
    EventoMapper eventoMapper;
    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    Notificador notificador;

    public void criarEventoProjeto(List<Projeto> projetos) {
        LocalDateTime dataHoje = LocalDateTime.now();

        if (projetos.isEmpty()) {
            throw  new ListaVaziaException("A lista está vazia");
        }

        for (Projeto projeto : projetos) {
            Evento evento = new Evento();
            evento.setIdEvento(null);
            evento.setDataInicio(projeto.getDataInicio());
            evento.setDataTermino(projeto.getDataEntrega());
            evento.setTipo(Tipo.PROJETO);
            evento.setDescricao(projeto.getDescricao());
            evento.setStatus(projeto.getStatus());
            evento.setDataCriacao(dataHoje);
            evento.setStatus(projeto.getStatus());
            evento.setProjeto(projeto);
            evento.setNegocio(projeto.getNegocio());

            eventoRepository.save(evento);
        }
    }

    public EventoResponseDTO atualizarEvento(UUID idEvento, Evento eventoAtualizado) {
        Optional<Evento> eventoExistenteOptional = eventoRepository.findById(idEvento);

        if (eventoExistenteOptional.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Evento não encontrado");
        }

        Evento eventoExistente = eventoExistenteOptional.get();

        if (eventoAtualizado.getDataInicio() != null) {
            eventoExistente.setDataInicio(eventoAtualizado.getDataInicio());
        }
        if (eventoAtualizado.getDataTermino() != null) {
            eventoExistente.setDataTermino(eventoAtualizado.getDataTermino());
        }
        if (eventoAtualizado.getDescricao() != null) {
            eventoExistente.setDescricao(eventoAtualizado.getDescricao());
        }
        if (eventoAtualizado.getTipo() != null) {
            eventoExistente.setTipo(eventoAtualizado.getTipo());
        }
        if (eventoAtualizado.getStatus() != null) {
            eventoExistente.setStatus(eventoAtualizado.getStatus());
        }

        eventoRepository.save(eventoExistente);

        String tempoRestante = calcularTempoRestante(eventoExistente);
        EventoResponseDTO eventoResponseDTO = eventoMapper.toDto(eventoExistente);
        eventoResponseDTO.setTempoRestante(tempoRestante);
        notificador.notificarObservers(eventoResponseDTO);

        return eventoResponseDTO;
    }

    public String calcularTempoRestante(Evento evento) {
        LocalDateTime dataHoje = LocalDateTime.now();
        LocalDateTime prazoFinal = evento.getDataTermino();

        Long diasRestantes = ChronoUnit.DAYS.between(dataHoje, prazoFinal);
        long horasRestantes = ChronoUnit.HOURS.between(dataHoje.plusDays(diasRestantes), prazoFinal);
        long minutosRestantes = ChronoUnit.MINUTES.between(dataHoje.plusDays(diasRestantes).plusHours(horasRestantes), prazoFinal);
        return "%d dias, %d horas e %d minutos".formatted(diasRestantes, horasRestantes, minutosRestantes);
    }

    public Integer extrairDias(String tempoRestante) {
        String[] partes = tempoRestante.split(" ");
        if (partes.length > 0) {
            return Integer.parseInt(partes[0]);
        }
        throw new NumberFormatException();
    }

    public Prioridade calcularPrioridade(Evento evento) {
        String tempoRestante = calcularTempoRestante(evento);
        Integer diasRestantes = extrairDias(tempoRestante);

        Prioridade definirPrioridade;
        if (diasRestantes <= 7 && diasRestantes >= 5) {
            definirPrioridade = Prioridade.BAIXA;
        } else if (diasRestantes <= 4) {
            definirPrioridade = Prioridade.MEDIA;
        } else {
            definirPrioridade = Prioridade.ALTA;
        }
        return definirPrioridade;
    }
}
