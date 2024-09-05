package Facts.Arch.ArchFacts.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String conteudo;
    private LocalDate dataEnvio;
    @ManyToOne
    @JoinColumn (name = "fkRemetente")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn (name = "fkNegocio") // Destinatário
    private Negocio negocio;

    public Mensagem() {
    }

    public Mensagem(UUID id, String conteudo, LocalDate dataEnvio, Usuario remetente, Negocio negocio) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.remetente = remetente;
        this.negocio = negocio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDate dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", remetente=" + remetente +
                ", negocio=" + negocio +
                '}';
    }
}
