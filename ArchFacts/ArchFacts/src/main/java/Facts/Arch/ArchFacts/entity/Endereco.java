package Facts.Arch.ArchFacts.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String cep;
    private String estado;
    private String bairro;
    private String rua;
    @OneToOne
    @JoinColumn(name = "fkNegocio")
    Negocio negocio;

    public Endereco() {
    }

    public Endereco(UUID id, String cep, String estado, String bairro, String rua, Negocio negocio) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.bairro = bairro;
        this.rua = rua;
        this.negocio = negocio;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' +
                ", rua='" + rua + '\'' +
                ", negocio=" + negocio +
                '}';
    }
}
