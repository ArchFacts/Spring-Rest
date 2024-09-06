package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Projeto;
import Facts.Arch.ArchFacts.entity.Usuario;

public interface EstrategiaConfiguracao {
    void configurarCampos(Negocio negocio);
    void configurarCampos(Projeto projeto);
    void configurarCampos(Usuario usuario);
}
