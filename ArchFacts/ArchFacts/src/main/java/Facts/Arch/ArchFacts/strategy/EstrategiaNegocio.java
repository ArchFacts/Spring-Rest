package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.enumeration.Role;

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

    @Override
    public void configurarCampos(Proposta proposta) {

    }

    @Override
    public void configurarCampos(Servico servico) {

    }
}
