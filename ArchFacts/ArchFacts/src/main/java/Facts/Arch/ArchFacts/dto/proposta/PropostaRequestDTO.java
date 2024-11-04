package Facts.Arch.ArchFacts.dto.proposta;

import java.time.LocalDateTime;

public class PropostaRequestDTO {
    String titulo;
    String cep;
    String endereco;
    String numero;
    String complemento;
    LocalDateTime data;
    String descricao;

    public PropostaRequestDTO() {
    }

    public PropostaRequestDTO(String titulo, String cep, String endereco, String numero, String complemento,
                              LocalDateTime data, String descricao) {
        this.titulo = titulo;
        this.cep = cep;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.data = data;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
