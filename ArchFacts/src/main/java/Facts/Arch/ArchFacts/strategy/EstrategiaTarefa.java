package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.*;

import java.time.LocalDateTime;

public class EstrategiaTarefa implements EstrategiaConfiguracao{
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

    }

    @Override
    public void configurarCampos(Servico servico) {

    }

    @Override
    public void configurarCampos(Tarefa tarefa) {
        tarefa.setIdTarefa(null);
        tarefa.setDataInicio(LocalDateTime.now());
    }
}
