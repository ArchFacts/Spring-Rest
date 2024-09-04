package facts.arch.ArchFacts.API.REST.entity;

import facts.arch.ArchFacts.API.REST.enums.Prioridade;
import facts.arch.ArchFacts.API.REST.enums.Status;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Ticket {
    private Integer id;
    private String descricao;
    private LocalDate abertura;
    private LocalDate fechamento;
    private Status status;
    private Prioridade prioridade;

    public Ticket() {
    }

    public Ticket(Integer id,
                  String descricao,
                  LocalDate abertura,
                  LocalDate fechamento,
                  Status status,
                  Prioridade prioridade) {
        this.id = id;
        this.descricao = descricao;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.status = status;
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDate abertura) {
        this.abertura = abertura;
    }

    public LocalDate getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalDate fechamento) {
        this.fechamento = fechamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", abertura=" + abertura +
                ", fechamento=" + fechamento +
                ", status=" + status +
                ", prioridade=" + prioridade +
                '}';
    }
}
