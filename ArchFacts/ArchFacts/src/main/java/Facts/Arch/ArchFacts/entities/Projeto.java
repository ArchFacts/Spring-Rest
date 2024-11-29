package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enumeration.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;
@Entity
public class Projeto {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "idProjeto", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idProjeto;
    @Schema(description = "Campo que representa o nome do projeto", example = "Re-Data")
    private String nome;
    @Schema(description = "Campo que representa a descrição do projeto", example = "Projeto para monitorar computadores que fazem processo ETL")
    private String descricao;
    @Schema(description = "Campo que representa o custo do projeto", example = "2000.30")
    private Double custo;
    @Schema(description = "Campo que representa a data de início do projeto", example = "2022-01-20 20:30:00")
    private LocalDateTime dataInicio;
    @Schema(description = "Campo que representa a data de entrega do projeto", example = "2023-10-02")
    private LocalDateTime dataEntrega;
    @Schema(description = "Campo que representa o status do projeto", example = "pendente")
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn (name = "fkNegocio")
    private Negocio negocio;
    @OneToOne
    @JoinColumn (name = "fkBeneficiario", referencedColumnName = "idUsuario")
    private Usuario destinatario;

    public Projeto() {
    }

    public Projeto(UUID idProjeto, String nome, String descricao, Double custo, LocalDateTime dataInicio,
                   LocalDateTime dataEntrega, Status status, Negocio negocio, Usuario usuario) {
        this.idProjeto = idProjeto;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.negocio = negocio;
        this.destinatario = usuario;
    }

    public UUID getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(UUID idProjeto) {
        this.idProjeto = idProjeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario usuario) {
        this.destinatario = usuario;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "idProjeto=" + idProjeto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", custo=" + custo +
                ", dataInicio=" + dataInicio +
                ", dataEntrega=" + dataEntrega +
                ", status=" + status +
                ", negocio=" + negocio +
                '}';
    }
}
