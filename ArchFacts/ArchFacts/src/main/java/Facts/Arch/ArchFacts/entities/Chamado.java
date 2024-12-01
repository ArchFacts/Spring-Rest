package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idChamado", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idChamado;
    private String titulo;
    private String descricao;
    private LocalDateTime abertura;
    private LocalDateTime fechamento;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Double lucro;
    @JoinColumn (name = "fkProjeto", referencedColumnName = "idProjeto")
    @ManyToOne
    Projeto projeto;

    public Chamado() {
    }

    public Chamado(UUID idChamado, String titulo, String descricao, LocalDateTime abertura, LocalDateTime fechamento,
                   Status status, Double lucro, Projeto projeto) {
        this.idChamado = idChamado;
        this.titulo = titulo;
        this.descricao = descricao;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.status = status;
        this.lucro = lucro;
        this.projeto = projeto;
    }

    public UUID getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(UUID idChamado) {
        this.idChamado = idChamado;
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

    public LocalDateTime getAbertura() {
        return abertura;
    }

    public void setAbertura(LocalDateTime abertura) {
        this.abertura = abertura;
    }

    public LocalDateTime getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalDateTime fechamento) {
        this.fechamento = fechamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "idChamado=" + idChamado +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", abertura=" + abertura +
                ", fechamento=" + fechamento +
                ", status=" + status +
                ", lucro=" + lucro +
                ", projeto=" + projeto +
                '}';
    }
}
