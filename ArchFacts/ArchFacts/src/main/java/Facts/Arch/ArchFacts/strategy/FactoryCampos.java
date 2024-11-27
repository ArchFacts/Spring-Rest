    package Facts.Arch.ArchFacts.strategy;
    
    import Facts.Arch.ArchFacts.entities.*;

    public class FactoryCampos {
        private EstrategiaConfiguracao estrategiaConfiguracao;
    
        public FactoryCampos(EstrategiaConfiguracao estrategiaConfiguracao) {
            this.estrategiaConfiguracao = estrategiaConfiguracao;
        }
    
        public FactoryCampos() {
        }
    
        public void configurarCampos(Object objetoGenerico) {
            if (objetoGenerico instanceof Negocio) {
                estrategiaConfiguracao.configurarCampos((Negocio) objetoGenerico);
            } else if (objetoGenerico instanceof Projeto) {
                estrategiaConfiguracao.configurarCampos((Projeto) objetoGenerico);
            } else if (objetoGenerico instanceof Usuario) {
                estrategiaConfiguracao.configurarCampos((Usuario) objetoGenerico);
            } else if (objetoGenerico instanceof Proposta) {
                estrategiaConfiguracao.configurarCampos((Proposta) objetoGenerico);
            } else if (objetoGenerico instanceof Servico) {
                estrategiaConfiguracao.configurarCampos((Servico) objetoGenerico);
            } else {
                System.out.println("Não há uma estratégia definida");
            }
        }
    }
