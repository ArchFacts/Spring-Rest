package Facts.Arch.ArchFacts.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.UUID;
public class Endereco {
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

    public Endereco() {
    }

    public Endereco(String cep, String estado, String bairro, String cidade, String rua, Integer numero) {
        this.cep = cep;
        this.estado = estado;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
