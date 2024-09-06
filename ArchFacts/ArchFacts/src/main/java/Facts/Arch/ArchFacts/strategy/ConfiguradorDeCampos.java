    package Facts.Arch.ArchFacts.strategy;
    
    import Facts.Arch.ArchFacts.entity.Negocio;
    import Facts.Arch.ArchFacts.entity.Projeto;
    import Facts.Arch.ArchFacts.entity.Usuario;
    
    public class ConfiguradorDeCampos {
        private EstrategiaConfiguracao estrategiaConfiguracao;
    
        public ConfiguradorDeCampos(EstrategiaConfiguracao estrategiaConfiguracao) {
            this.estrategiaConfiguracao = estrategiaConfiguracao;
        }
    
        public ConfiguradorDeCampos() {
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
