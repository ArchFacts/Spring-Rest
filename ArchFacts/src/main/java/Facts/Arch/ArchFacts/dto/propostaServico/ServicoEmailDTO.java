package Facts.Arch.ArchFacts.dto.propostaServico;

import Facts.Arch.ArchFacts.entities.Servico;

public class ServicoEmailDTO {
    private Servico servico;
    private String email;

    public ServicoEmailDTO() {
    }

    public ServicoEmailDTO(Servico servico, String email) {
        this.servico = servico;
        this.email = email;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
