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
    @Column(name = "idUsuario", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idParcela;
    private Double valor;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    @Enumerated
    private Status status;
    @OneToOne
    private Chamado chamado;
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