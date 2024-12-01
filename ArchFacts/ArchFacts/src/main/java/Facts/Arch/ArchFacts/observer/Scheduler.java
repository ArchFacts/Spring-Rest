//package Facts.Arch.ArchFacts.observer;
//
//import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
//import Facts.Arch.ArchFacts.dto.mapper.EventoMapper;
//import Facts.Arch.ArchFacts.entities.Evento;
//import Facts.Arch.ArchFacts.entities.Projeto;
//import Facts.Arch.ArchFacts.enumeration.Prioridade;
//import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
//import Facts.Arch.ArchFacts.repositories.EventoRepository;
//import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
//import Facts.Arch.ArchFacts.services.EventoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class Scheduler {
//    @Autowired
//    private EventoService eventoService;
//    @Autowired
//    private Observer observer;
//    @Autowired
//    private EventoRepository eventoRepository;
//    @Autowired
//    private EventoMapper eventoMapper;
//    @Autowired
//    private ProjetoRepository projetoRepository;
//
//    // @Scheduled(fixedRate = 60000) // 1min
//    public List<Projeto> verificarProjetos() {
//        List<Projeto> projetos = projetoRepository.findAll();
//        LocalDateTime dataHoje = LocalDateTime.now();
//
//        List<Projeto> projetosDataProxima = new ArrayList<>();
//
//        for (Projeto projeto : projetos) {
//            LocalDateTime dataEntregaProjeto = projeto.getDataEntrega();
//            if (dataEntregaProjeto.minusDays(3).isBefore(dataHoje)) {
//                Boolean eventoExistente = eventoRepository.findAll().stream()
//                        .anyMatch(evento -> evento.getProjeto().getIdProjeto().equals(projeto.getIdProjeto())
//                                && evento.getDataTermino().equals(dataEntregaProjeto));
//
//                if (eventoExistente) {
//                    projetosDataProxima.add(projeto);
//                }
//            }
//        }
//        return projetos;
//    }
//
//    public void verificarEventos() {
//        System.out.println("Iniciando verificação de eventos...");
//        List<Evento> eventos = eventoRepository.findAll(); // Busca todos os eventos
//        System.out.println("Eventos encontrados: " + eventos.size());
//        if (eventos.isEmpty()) {
//            throw new EntidadeNaoEncontradaException("A lista de eventos ainda está vazia");
//        }
//        LocalDateTime dataHoje = LocalDateTime.now(); // Obtém a data atual
//
//        for (Evento evento : eventos) {
//            String diasRestantes = eventoService.calcularTempoRestante(evento);
//            Prioridade prioridadeAtual = eventoService.calcularPrioridade(evento);
//
//            EventoResponseDTO eventoResponseDTO = eventoMapper.toDto(evento);
//
//            boolean precisaNotificar = false;
//
//
//            // IMPLEMENTAR AQUI O ENVIO DE EMAIL
//            if (!eventoResponseDTO.getTempoRestante().equals(diasRestantes)) {
//                precisaNotificar = true;
//
//                eventoResponseDTO.setTempoRestante(diasRestantes);
//                eventoResponseDTO.setPrioridade(prioridadeAtual);
//                eventoResponseDTO.setDataInicio(evento.getDataInicio());
//                eventoResponseDTO.setDataTermino(evento.getDataTermino());
//                eventoResponseDTO.setDescricao(evento.getDescricao());
//                eventoResponseDTO.setStatus(evento.getStatus());
//            }
//
//            if (precisaNotificar) {
//                observer.notificarObservers(eventoResponseDTO);
//            }
//        }
//    }
//
//    public List<EventoResponseDTO> buscarEventosAtualizados() {
//
//        Optional<List<Evento>> eventosOptional = Optional.of(eventoRepository.findAll());
//        if (eventosOptional.isEmpty()) {
//            throw new EntidadeNaoEncontradaException("Ainda não há nenhum evento");
//        }
//        List<Evento> eventos = eventosOptional.get();
//
//        List<EventoResponseDTO> eventoResponseDTOS = new ArrayList<>();
//
//        for (Evento evento : eventos) {
//            EventoResponseDTO eventoResponseDTO = eventoMapper.toDto(evento);
//            eventoResponseDTOS.add(eventoResponseDTO);
//        }
//            return eventoResponseDTOS;
//    }
//}
