package Facts.Arch.ArchFacts.dto.propostaServico;

import Facts.Arch.ArchFacts.entities.Proposta;

public class PropostaServicoResponseDTO {
    private String idProposta;
    private String fkRemetente;
    private String fkDestinatario;
    private String idServico;
    private String fkNegocio;

    public String getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(String idProposta) {
        this.idProposta = idProposta;
    }

    public String getFkRemetente() {
        return fkRemetente;
    }

    public void setFkRemetente(String fkRemetente) {
        this.fkRemetente = fkRemetente;
    }

    public String getFkDestinatario() {
        return fkDestinatario;
    }

    public void setFkDestinatario(String fkDestinatario) {
        this.fkDestinatario = fkDestinatario;
    }

    public String getIdServico() {
        return idServico;
    }

    public void setIdServico(String idServico) {
        this.idServico = idServico;
    }

    public String getFkNegocio() {
        return fkNegocio;
    }

    public void setFkNegocio(String fkNegocio) {
        this.fkNegocio = fkNegocio;
    }

    @Override
    public String toString() {
        return "PropostaServicoResponseDTO{" +
                "idProposta='" + idProposta + '\'' +
                ", fkRemetente='" + fkRemetente + '\'' +
                ", fkDestinatario='" + fkDestinatario + '\'' +
                ", idServico='" + idServico + '\'' +
                ", fkNegocio='" + fkNegocio + '\'' +
                '}';
    }
}
