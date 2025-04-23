package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idEvento", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idEvento;
    @Column(name = "idEntidade", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idEntidade;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private LocalDateTime dataCriacao;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    private String descricao;
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne
    @JoinColumn(name = "fkProjeto", nullable = false) // Especificando a coluna
    private Projeto projeto;
    @ManyToOne
    @JoinColumn(name = "fkNegocio", nullable = false)
    private Negocio negocio;

    public Evento() {
    }

    public Evento(UUID idEvento,
                  UUID idEntidade,
                  LocalDateTime dataInicio,
                  LocalDateTime dataTermino,
                  LocalDateTime dataCriacao,
                  Tipo tipo,
                  Prioridade prioridade,
                  String descricao,
                  Status status,
                  Projeto projeto,
                  Negocio negocio) {
        this.idEvento = idEvento;
        this.idEntidade = idEntidade;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.dataCriacao = dataCriacao;
        this.tipo = tipo;
        this.prioridade = prioridade;
        this.descricao = descricao;
        this.status = status;
        this.projeto = projeto;
        this.negocio = negocio;
    }

    public UUID getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(UUID idEvento) {
        this.idEvento = idEvento;
    }

    public UUID getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(UUID idEntidade) {
        this.idEntidade = idEntidade;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "idEvento=" + idEvento +
                ", idEntidade=" + idEntidade +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", dataCriacao=" + dataCriacao +
                ", tipo=" + tipo +
                ", prioridade=" + prioridade +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", projeto=" + projeto +
                ", negocio=" + negocio +
                '}';
    }
}
