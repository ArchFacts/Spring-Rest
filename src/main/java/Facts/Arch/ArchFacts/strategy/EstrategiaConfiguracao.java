package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Usuario;

public interface EstrategiaConfiguracao {
    void configurarCampos(Negocio negocio);
    void configurarCampos(Projeto projeto);
    void configurarCampos(Usuario usuario, Negocio negocioSolicitado);
    void configurarCampos(Usuario usuarioSolicitado);
}
