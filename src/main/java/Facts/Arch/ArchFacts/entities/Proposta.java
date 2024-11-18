package Facts.Arch.ArchFacts.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idProposta;
    private String conteudo;
    private LocalDateTime dataEnvio;
    @ManyToOne
    Usuario usuario;
    @ManyToOne
    Negocio negocio;

    public Proposta() {
    }

    public Proposta(UUID idProposta, String conteudo, LocalDateTime dataEnvio, Usuario usuario, Negocio negocio) {
        this.idProposta = idProposta;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.usuario = usuario;
        this.negocio = negocio;
    }

    public UUID getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(UUID idProposta) {
        this.idProposta = idProposta;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "idProposta=" + idProposta +
                ", conteudo='" + conteudo + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", usuario=" + usuario +
                ", negocio=" + negocio +
                '}';
    }
}
