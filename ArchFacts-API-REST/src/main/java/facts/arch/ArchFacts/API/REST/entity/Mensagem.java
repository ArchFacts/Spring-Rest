package facts.arch.ArchFacts.API.REST.entity;

import java.time.LocalDate;

public class Mensagem {
    private Integer id;
    private String conteudo;
    private LocalDate dataEnvio;
    private Usuario remetente;
    private Usuario destinatario;

    public Mensagem() {
    }

    public Mensagem(Integer id, String conteudo, LocalDate dataEnvio, Usuario remetente, Usuario destinatario) {
        this.id = id;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", remetente=" + remetente +
                ", destinatario=" + destinatario +
                '}';
    }
}
