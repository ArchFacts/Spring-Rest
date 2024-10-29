package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaProjeto;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;
    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    public Projeto criarProjeto (Projeto projeto) {
        Projeto projetoCadastro = projeto;

        EstrategiaProjeto estrategiaProjeto = new EstrategiaProjeto();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaProjeto);
        factoryCampos.configurarCampos(projetoCadastro);

        Usuario usuarioSolicitante = usuarioLogadoService.obterSessao();
        projeto.setDestinatario(usuarioSolicitante);
        projeto.setNegocio(negocioRepository.findByNome("Negócio Exemplo"));

        return projetoRepository.save(projeto);
    }
}
