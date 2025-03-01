package Facts.Arch.ArchFacts.dto.proposta;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PropostaRequestDTO {
    private String titulo;
    private String cep;
    private String endereco;
    private Integer numero;
    private String complemento;
    private LocalDateTime dataEntrega;
    private String descricao;

    public PropostaRequestDTO() {
    }

    public PropostaRequestDTO(String titulo, String cep, String endereco, Integer numero,
                              String complemento, LocalDateTime dataEntrega, String descricao) {
        this.titulo = titulo;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.dataEntrega = dataEntrega;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "PropostaRequestDTO{" +
                "titulo='" + titulo + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", dataEntrega='" + dataEntrega + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
