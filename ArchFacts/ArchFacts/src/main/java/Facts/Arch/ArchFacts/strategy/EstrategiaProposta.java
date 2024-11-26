package Facts.Arch.ArchFacts.strategy;

import Facts.Arch.ArchFacts.entities.Proposta;

import java.time.LocalDateTime;

public class EstrategiaProposta implements EstrategiaConfiguracao{
    @Override
    public void configurarCampos(Proposta proposta) {
        proposta.setIdProposta(null);
        proposta.setDataEnvio(LocalDateTime.now());
    }
}
