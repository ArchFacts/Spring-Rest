package Facts.Arch.ArchFacts.dto.propostaServico;

import Facts.Arch.ArchFacts.entities.Servico;

import java.util.List;

public class PropostasAbertasResumoRespostaDTO {
    private String solicitante;
    List<Servico> servicosEscolhidos;
    private String emailSolicitante;
    private String descricaoServico;

    public PropostasAbertasResumoRespostaDTO() {
    }

    public PropostasAbertasResumoRespostaDTO(String solicitante,
                                             List<Servico> servicosEscolhidos,
                                             String emailSolicitante,
                                             String descricaoServico) {
        this.solicitante = solicitante;
        this.servicosEscolhidos = servicosEscolhidos;
        this.emailSolicitante = emailSolicitante;
        this.descricaoServico = descricaoServico;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public List<Servico> getServicosEscolhidos() {
        return servicosEscolhidos;
    }

    public void setServicosEscolhidos(List<Servico> servicosEscolhidos) {
        this.servicosEscolhidos = servicosEscolhidos;
    }

    public String getEmailSolicitante() {
        return emailSolicitante;
    }

    public void setEmailSolicitante(String emailSolicitante) {
        this.emailSolicitante = emailSolicitante;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    @Override
    public String toString() {
        return "PropostasAbertasResumoRespostaDTO{" +
                "solicitante='" + solicitante + '\'' +
                ", servicosEscolhidos=" + servicosEscolhidos +
                ", emailSolicitante='" + emailSolicitante + '\'' +
                ", descricaoServico='" + descricaoServico + '\'' +
                '}';
    }
}
