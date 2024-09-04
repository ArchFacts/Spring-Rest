package Facts.Arch.ArchFacts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Task {
    private UUID id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    @ManyToOne
    @JoinColumn(name = "fkProjeto")
    Projeto projeto;
    @ManyToOne
    @JoinColumn(name = "fkTicket")
    Ticket ticket;
    List<Pagamento> pagamentoList = new ArrayList<>();

    public Task() {
    }

    public Task(UUID id, LocalDate dataInicio, LocalDate dataTermino, Projeto projeto) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.projeto = projeto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", projeto=" + projeto +
                '}';
    }
}
