package Facts.Arch.ArchFacts.dto.negocio;

import java.time.LocalDateTime;

public class NegocioResponseDTO {
    private String nome;
    private String codigo;
    private String cep;
    private String cpf;
    private String cnpj;
    private LocalDateTime dataRegistro;

    public NegocioResponseDTO() {
    }

    public NegocioResponseDTO(String nome, String codigo, String cep, String cpf, String cnpj, LocalDateTime dataRegistro) {
        this.nome = nome;
        this.codigo = codigo;
        this.cep = cep;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.dataRegistro = dataRegistro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
