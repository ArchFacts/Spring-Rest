package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entity.Negocio;
import Facts.Arch.ArchFacts.entity.Projeto;
import Facts.Arch.ArchFacts.entity.Usuario;

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
    public void configurarCampos(Usuario usuario) {

    }
}
