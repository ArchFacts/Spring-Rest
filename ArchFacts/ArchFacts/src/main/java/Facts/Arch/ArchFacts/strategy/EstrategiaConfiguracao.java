package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.*;

public interface EstrategiaConfiguracao {
    void configurarCampos(Negocio negocio);
    void configurarCampos(Projeto projeto);
    void configurarCampos(Usuario usuario, Negocio negocioSolicitado);
    void configurarCampos(Usuario usuarioSolicitado);
    void configurarCampos(Proposta proposta);
    void configurarCampos(Servico servico);

}
