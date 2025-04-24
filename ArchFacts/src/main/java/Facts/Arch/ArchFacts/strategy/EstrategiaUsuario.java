package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.*;
import Facts.Arch.ArchFacts.enumeration.Role;

import java.time.LocalDateTime;

public class EstrategiaUsuario implements EstrategiaConfiguracao {
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
        usuarioSolicitado.setIdUsuario(null);
        usuarioSolicitado.setRole(Role.USER);
        usuarioSolicitado.setAtivado(Boolean.TRUE);
        usuarioSolicitado.setDataRegistro(LocalDateTime.now());
    }

    @Override
    public void configurarCampos(Proposta proposta) {

    }

    @Override
    public void configurarCampos(Servico servico) {

    }

    @Override
    public void configurarCampos(Tarefa tarefa) {

    }
}
