package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private LocalDate abertura;
    private LocalDate fechamento;
    private Status status;
    @ManyToOne
    @JoinColumn (name = "fkProjeto")
    Projeto projeto;
    @ManyToOne
    @JoinColumn (name = "fkUsuario")
    Usuario usuario;

    public Ticket(UUID id, String descricao, LocalDate abertura, LocalDate fechamento, Status status, Projeto projeto,
                  Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.status = status;
        this.projeto = projeto;
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", abertura=" + abertura +
                ", fechamento=" + fechamento +
                ", status=" + status +
                ", projeto=" + projeto +
                ", usuario=" + usuario +
//                ", taskList=" + taskList +
                '}';
    }
}
