package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.*;

import java.time.LocalDateTime;

public class EstrategiaProposta implements EstrategiaConfiguracao{
    @Override
    public void configurarCampos(Negocio negocio) {

    }

    @Override
    public void configurarCampos(Projeto projeto) {

    }

    @Override
    public void configurarCampos(Usuario usuario, Negocio negocioSolicitado) {

    }

    @Override
    public void configurarCampos(Usuario usuarioSolicitado) {

    }

    @Override
    public void configurarCampos(Proposta proposta) {
        proposta.setIdProposta(null);
        proposta.setDataEnvio(LocalDateTime.now());
    }

    @Override
    public void configurarCampos(Servico servico) {

    }

    @Override
    public void configurarCampos(Tarefa tarefa) {

    }
}
