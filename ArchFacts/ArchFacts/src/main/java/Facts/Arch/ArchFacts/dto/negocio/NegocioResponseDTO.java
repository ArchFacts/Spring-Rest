package Facts.Arch.ArchFacts.dto.negocio;

import java.time.LocalDateTime;

public class NegocioResponseDTO {
    private String nomeEmpresa;
    private String nomeSolicitante;
    private String emailEmpresa;
    private String emailSolicitante;
    private String cep;
    private String endereco;
    private String bairro;
    private Integer numero;
    private String complemento;
    private LocalDateTime dataEntrega;
    public NegocioResponseDTO() {
    }

    public NegocioResponseDTO(String nomeEmpresa,
                              String nomeSolicitante,
                              String emailEmpresa,
                              String emailSolicitante,
                              String cep,
                              String endereco,
                              String bairro,
                              Integer numero,
                              String complemento,
                              LocalDateTime dataEntrega) {
        this.nomeEmpresa = nomeEmpresa;
        this.nomeSolicitante = nomeSolicitante;
        this.emailEmpresa = emailEmpresa;
        this.emailSolicitante = emailSolicitante;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.dataEntrega = dataEntrega;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeSolicitante() {
        return nomeSolicitante;
    }

    public void setNomeSolicitante(String nomeSolicitante) {
        this.nomeSolicitante = nomeSolicitante;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
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

    @Override
    public String toString() {
        return "NegocioResponseDTO{" +
                "nomeEmpresa='" + nomeEmpresa + '\'' +
                ", nomeSolicitante='" + nomeSolicitante + '\'' +
                ", emailEmpresa='" + emailEmpresa + '\'' +
                ", emailSolicitante='" + emailSolicitante + '\'' +
                ", cep='" + cep + '\'' +
                ", endereco='" + endereco + '\'' +
                ", bairro='" + bairro + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", dataEntrega=" + dataEntrega +
                '}';
    }
}
