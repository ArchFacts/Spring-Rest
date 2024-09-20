package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enums.Role;

import java.time.LocalDate;
import java.util.UUID;

public class EstrategiaNegocio implements EstrategiaConfiguracao {


    @Override
    public void configurarCampos(Negocio negocioSolicitado) {
        negocioSolicitado.setId(null);
        negocioSolicitado.setAtivado(Boolean.TRUE);
        negocioSolicitado.setCodigoNegocio(UUID.randomUUID().toString());
        negocioSolicitado.setDataRegistro(LocalDate.now());
    }

    @Override
    public void configurarCampos(Projeto projeto) {

    }

    @Override
    public void configurarCampos(Usuario usuarioSolicitado, Negocio negocioSolicitado) {
        usuarioSolicitado.setRole(Role.ADM);
        usuarioSolicitado.setNegocio(negocioSolicitado);
    }

    @Override
    public void configurarCampos(Usuario usuarioSolicitado) {

    }
}
