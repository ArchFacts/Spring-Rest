package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class EstrategiaNegocio implements EstrategiaConfiguracao {


    @Override
    public void configurarCampos(Negocio negocioSolicitado) {
        negocioSolicitado.setIdNegocio(null);
        negocioSolicitado.setAtivado(Boolean.TRUE);
        negocioSolicitado.setAvaliacao(0.0);
        negocioSolicitado.setCodigo(UUID.randomUUID().toString());
        negocioSolicitado.setDataRegistro(LocalDateTime.now());
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
