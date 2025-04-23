package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;

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
        projetoSolicitado.setStatus(Status.ABERTO);
    }

    @Override
    public void configurarCampos(Usuario usuario, Negocio negocioSolicitado) {

    }

    @Override
    public void configurarCampos(Usuario usuario) {

    }

    @Override
    public void configurarCampos(Proposta proposta) {

    }

    @Override
    public void configurarCampos(Servico servico) {

    }

    @Override
    public void configurarCampos(Tarefa tarefa) {

    }
}
