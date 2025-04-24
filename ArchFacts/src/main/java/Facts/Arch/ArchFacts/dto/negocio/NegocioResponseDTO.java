package Facts.Arch.ArchFacts.dto.negocio;

import java.time.LocalDateTime;

public class NegocioResponseDTO {
    private String nomeEmpresa;
    private String codigo;
    private String cep;
    private String endereco;
    private String cpf;
    private String cnpj;
    private LocalDateTime dataRegistro;
    public NegocioResponseDTO() {
    }

    public NegocioResponseDTO(String nomeEmpresa, String codigo, String cep, String endereco, String cpf,
                              String cnpj, LocalDateTime dataRegistro) {
        this.nomeEmpresa = nomeEmpresa;
        this.codigo = codigo;
        this.cep = cep;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.dataRegistro = dataRegistro;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
