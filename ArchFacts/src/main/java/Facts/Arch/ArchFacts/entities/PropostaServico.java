package Facts.Arch.ArchFacts.entities;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PropostaServico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idPropostaServico;
    @ManyToOne
    @JoinColumn(name = "idProposta", referencedColumnName = "idProposta")
    private Proposta proposta;

    @ManyToOne
    @JoinColumn(name = "idServico", referencedColumnName = "idServico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "fkRemetente", referencedColumnName = "idUsuario")
    private Usuario remetente;

    @ManyToOne
    @JoinColumn(name = "fkDestinatario", referencedColumnName = "idNegocio")
    private Negocio destinatario;

    private LocalDateTime dataCriacao;

    public PropostaServico() {
    }

    public PropostaServico(UUID idPropostaServico, Proposta proposta, Servico servico,
                           Usuario remetente, Negocio destinatario, LocalDateTime dataCriacao) {
        this.idPropostaServico = idPropostaServico;
        this.proposta = proposta;
        this.servico = servico;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.dataCriacao = dataCriacao;
    }

    public UUID getIdPropostaServico() {
        return idPropostaServico;
    }

    public void setIdPropostaServico(UUID idPropostaServico) {
        this.idPropostaServico = idPropostaServico;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Negocio getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Negocio destinatario) {
        this.destinatario = destinatario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "PropostaServico{" +
                "idPropostaServico='" + idPropostaServico + '\'' +
                ", proposta=" + proposta +
                ", servico=" + servico +
                ", remetente=" + remetente +
                ", destinatario=" + destinatario +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
