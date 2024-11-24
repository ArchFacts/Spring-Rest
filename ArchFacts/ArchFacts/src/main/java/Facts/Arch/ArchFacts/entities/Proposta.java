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
    private String servicosEscolhidos;
    @ManyToOne
    @JoinColumn(name = "fkRemetente")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn(name = "fkDestinatario")
    private Negocio destinatario;

    public Proposta() {
    }

    public Proposta(UUID idProposta,
                    String conteudo,
                    LocalDateTime dataEnvio,
                    String servicosEscolhidos,
                    Usuario remetente, Negocio destinatario) {
        this.idProposta = idProposta;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.servicosEscolhidos = servicosEscolhidos;
        this.remetente = remetente;
        this.destinatario = destinatario;
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

    public String getServicosEscolhidos() {
        return servicosEscolhidos;
    }

    public void setServicosEscolhidos(String servicosEscolhidos) {
        this.servicosEscolhidos = servicosEscolhidos;
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

    @Override
    public String toString() {
        return "Proposta{" +
                "idProposta=" + idProposta +
                ", conteudo='" + conteudo + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", servicosEscolhidos='" + servicosEscolhidos + '\'' +
                ", remetente=" + remetente +
                ", destinatario=" + destinatario +
                '}';
    }
}
