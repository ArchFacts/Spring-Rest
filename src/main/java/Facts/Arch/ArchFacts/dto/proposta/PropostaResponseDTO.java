package Facts.Arch.ArchFacts.dto.proposta;

import java.time.LocalDateTime;

public class PropostaResponseDTO {
    String empresa;
    String solicitante;
    String emailEmpresa;
    String emailSolicitante;
    String cep;
    String endereco;
    String bairro;
    String numero;
    String complemento;
    LocalDateTime data;

    public PropostaResponseDTO() {
    }

    public PropostaResponseDTO(String empresa, String solicitante, String emailEmpresa, String emailSolicitante,
                               String cep, String endereco, String bairro, String numero, String complemento, LocalDateTime data) {
        this.empresa = empresa;
        this.solicitante = solicitante;
        this.emailEmpresa = emailEmpresa;
        this.emailSolicitante = emailSolicitante;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
        this.data = data;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
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
}
