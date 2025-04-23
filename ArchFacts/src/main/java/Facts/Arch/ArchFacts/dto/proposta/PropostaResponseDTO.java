package Facts.Arch.ArchFacts.dto.proposta;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;

import java.time.LocalDateTime;

public class PropostaResponseDTO {
    Negocio empresa;
    private Usuario solicitante;
    private String emailEmpresa;
    private String emailSolicitante;
    private String cep;
    private String endereco;
    private String bairro;
    private Integer numero;
    private String complemento;
    private LocalDateTime data;

    public PropostaResponseDTO() {
    }

    public PropostaResponseDTO(Negocio empresa, Usuario solicitante, String emailEmpresa, String emailSolicitante,
                               String cep, String endereco, String bairro, Integer numero, String complemento, LocalDateTime data) {
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

    public Negocio getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Negocio empresa) {
        this.empresa = empresa;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
