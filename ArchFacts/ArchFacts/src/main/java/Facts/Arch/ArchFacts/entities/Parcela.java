package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idParcela", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idParcela;
    private Double valor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    @Enumerated(EnumType.STRING)
    private Status status;
    @JoinColumn (name = "fkChamado", referencedColumnName = "idChamado")
    @OneToOne
    private Chamado chamado;
    @JoinColumn (name = "fkProjeto", referencedColumnName = "idProjeto")
    @OneToOne
    private Projeto projeto;

    public Parcela() {
    }

    public Parcela(UUID idParcela, Double valor, LocalDateTime dataInicio, LocalDateTime dataTermino, Status status,
                   Chamado chamado, Projeto projeto) {
        this.idParcela = idParcela;
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.status = status;
        this.chamado = chamado;
        this.projeto = projeto;
    }

    public UUID getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(UUID idParcela) {
        this.idParcela = idParcela;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "idParcela=" + idParcela +
                ", valor=" + valor +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", status=" + status +
                ", chamado=" + chamado +
                ", projeto=" + projeto +
                '}';
    }
}