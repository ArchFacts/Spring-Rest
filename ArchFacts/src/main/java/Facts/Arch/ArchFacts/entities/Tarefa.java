package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idTarefa", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idTarefa;
    private String titulo;
    private String descricao;
    private Double despesa;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "fkProjeto")
    Projeto projeto;

    public Tarefa() {
    }

    public Tarefa(UUID idTarefa, String titulo, String descricao, Double despesa,
                  LocalDateTime dataInicio, LocalDateTime dataTermino, Prioridade prioridade, Status status,
                  Projeto projeto) {
        this.idTarefa = idTarefa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.despesa = despesa;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.status = status;
        this.projeto = projeto;
    }

    public UUID getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(UUID idTarefa) {
        this.idTarefa = idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getDespesa() {
        return despesa;
    }

    public void setDespesa(Double despesa) {
        this.despesa = despesa;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
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

    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa=" + idTarefa +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", despesa=" + despesa +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", projeto=" + projeto +
                '}';
    }
}
