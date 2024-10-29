package Facts.Arch.ArchFacts.observer;


import Facts.Arch.ArchFacts.dto.evento.EventoResponseDTO;
import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enums.Tipo;
import Facts.Arch.ArchFacts.repositories.EventoRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class Agendador implements GerenciadorEvento{
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private Notificador notificador;
    @Autowired
    private ProjetoRepository projetoRepository;
    @Scheduled(fixedRate = 60000) // 1min
    public void verificarProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        LocalDateTime dataHoje = LocalDateTime.now();

        for (Projeto projeto: projetos) {
            LocalDateTime dataEntregaProjeto = projeto.getDataEntrega();

            if (dataEntregaProjeto.minusDays(3).isBefore(dataHoje)) {
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
    }

    @Override
    public void atualizar(EventoResponseDTO eventoResponseDTO) {

    }
}
