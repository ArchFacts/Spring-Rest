package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Ticket {
    private UUID id;
    private String descricao;
    private LocalDate abertura;
    private LocalDate fechamento;
    private Status status;
    private Prioridade prioridade;
    @ManyToOne
    @JoinColumn (name = "fkProjeto")
    Projeto projeto;
    @ManyToOne
    @JoinColumn (name = "fkUsuario")
    Usuario usuario;
    private List<Task> taskList = new ArrayList<>();
}
