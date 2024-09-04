package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Projeto {
    private UUID id;
    private String nome;
    private String descricao;
    private Double custo;
    private LocalDate dataInicio;
    private LocalDate dataEntrega;
    private Status status;
    @ManyToOne
    @JoinColumn (name = "fkNegocio")
    Negocio negocio;
    @ManyToOne
    @JoinColumn (name = "fkDestinatario")
    Usuario destinatario;
    List<Task> taskList = new ArrayList<>();
    List<Arquivo> arquivoList = new ArrayList<>();
    List<Ticket> ticketList = new ArrayList<>();

    public Projeto() {
    }

}
