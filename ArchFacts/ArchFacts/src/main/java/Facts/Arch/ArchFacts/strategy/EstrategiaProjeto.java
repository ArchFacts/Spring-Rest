package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enums.Status;

import java.time.LocalDate;

public class EstrategiaProjeto implements EstrategiaConfiguracao {
    private Usuario destinatario;
    private Negocio negocio;

    public EstrategiaProjeto(Usuario destinatario, Negocio negocio) {
        this.destinatario = destinatario;
        this.negocio = negocio;
    }

    public EstrategiaProjeto() {
    }

    @Override
    public void configurarCampos(Negocio negocio) {

    }

    @Override
    public void configurarCampos(Projeto projetoSolicitado) {
        projetoSolicitado.setId(null);
        projetoSolicitado.setStatus(Status.ABERTO);
        projetoSolicitado.setDestinatario(destinatario);
        projetoSolicitado.setDataInicio(LocalDate.now());
        projetoSolicitado.setNegocio(negocio);

    }

    @Override
    public void configurarCampos(Usuario usuario, Negocio negocioSolicitado) {

    }

    @Override
    public void configurarCampos(Usuario usuario) {

    }
}
