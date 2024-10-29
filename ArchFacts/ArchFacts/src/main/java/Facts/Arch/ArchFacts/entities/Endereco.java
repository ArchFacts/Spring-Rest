package Facts.Arch.ArchFacts.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Schema(description = "Campo que representa o CEP do endereço",example = "06315040")
    private String cep;
    @Schema(description = "Campo que representa o estado do endereço",example = "São Paulo")
    private String estado;
    @Schema(description = "Campo que representa o bairro do endereço",example = "Cerqueira César")
    private String bairro;
    @Schema(description = "Campo que representa a cidade do endereço",example = "São Paulo")
    private String cidade;
    @Schema(description = "Campo que representa a rua do endereço",example = "Rua Haddock Lobo")
    private String rua;
    @Schema(description = "Campo que representa o número do endereço",example = "10")
    private Integer numero;

    @OneToOne
    @JoinColumn(name = "fkNegocio")
    @JsonBackReference
    private Negocio negocio;
    public Endereco() {
    }

    public Endereco(UUID id, String cep, String estado, String bairro,
                    String cidade, String rua, Integer numero, Negocio negocio) {
        this.id = id;
        this.cep = cep;
        this.estado = estado;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", cep='" + cep + '\'' +
                ", estado='" + estado + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", negocio=" + negocio +
                '}';
    }
}
