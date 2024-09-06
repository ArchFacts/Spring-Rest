package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Projeto;
import Facts.Arch.ArchFacts.entity.Usuario;
import Facts.Arch.ArchFacts.enums.Role;

import java.time.LocalDate;

public class EstrategiaUsuario implements EstrategiaConfiguracao {
    @Override
    public void configurarCampos(Negocio negocio) {

    }

    @Override
    public void configurarCampos(Projeto projeto) {

    }

    @Override
    public void configurarCampos(Usuario usuarioSolicitado) {
            usuarioSolicitado.setRole(Role.USER);
            usuarioSolicitado.setAtivado(Boolean.TRUE);
            usuarioSolicitado.setDataRegistro(LocalDate.now());
    }
}
