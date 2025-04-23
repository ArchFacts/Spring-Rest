package Facts.Arch.ArchFacts.dto.propostaServico;

import java.util.UUID;

public class PropostaServicoRequestDTO {
    private UUID idServico;
    private String idRemetente;
    private UUID idDestinatario;

    public PropostaServicoRequestDTO() {
    }

    public UUID getIdServico() {
        return idServico;
    }

    public void setIdServico(UUID idServico) {
        this.idServico = idServico;
    }

    public String getIdRemetente() {
        return idRemetente;
    }

    public void setIdRemetente(String idRemetente) {
        this.idRemetente = idRemetente;
    }

    public UUID getIdDestinatario() {
        return idDestinatario;
    }

    public void setIdDestinatario(UUID idDestinatario) {
        this.idDestinatario = idDestinatario;
    }

    @Override
    public String toString() {
        return "PropostaServicoRequestDTO{" +
                "idServico=" + idServico +
                ", idRemetente='" + idRemetente + '\'' +
                ", idDestinatario=" + idDestinatario +
                '}';
    }
}
