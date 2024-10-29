package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enums.Status;

import java.time.LocalDateTime;

public class EstrategiaProjeto implements EstrategiaConfiguracao {
    private Usuario remetente;
    private Negocio destinatario;

    public EstrategiaProjeto(Usuario remetente, Negocio negocio) {
        this.remetente = remetente;
        this.destinatario = negocio;
    }

    public EstrategiaProjeto() {
    }

    @Override
    public void configurarCampos(Negocio negocio) {

    }

    @Override
    public void configurarCampos(Projeto projetoSolicitado) {
        projetoSolicitado.setIdProjeto(null);
        projetoSolicitado.setCusto(0.0);
        projetoSolicitado.setDataInicio(LocalDateTime.now());
        projetoSolicitado.setStatus(Status.PENDENTE);
        projetoSolicitado.setDestinatario(remetente);
        projetoSolicitado.setNegocio(destinatario);

    }

    @Override
    public void configurarCampos(Usuario usuario, Negocio negocioSolicitado) {

    }

    @Override
    public void configurarCampos(Usuario usuario) {

    }
}
