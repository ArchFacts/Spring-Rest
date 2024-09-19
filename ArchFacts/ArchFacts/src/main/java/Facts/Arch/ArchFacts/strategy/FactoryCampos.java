    package Facts.Arch.ArchFacts.strategy;
    
    import Facts.Arch.ArchFacts.entity.Negocio;
    import Facts.Arch.ArchFacts.entity.Projeto;
    import Facts.Arch.ArchFacts.entity.Usuario;
    
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
            } else {
                System.out.println("Não há uma estratégia definida");
            }
        }
    }