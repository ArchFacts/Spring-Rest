package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.exceptions.EntidadeAtivadaException;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.repositories.EnderecoRepository;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaNegocio;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class NegocioService {
    @Autowired
    private NegocioRepository negocioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    private Negocio verificarEstadoNegocio (Negocio negocioSolicitado) {
        Boolean negocioExistente = this.negocioRepository.existsByCpfOrCnpj(
                negocioSolicitado.getCpf(), negocioSolicitado.getCnpj());

        if (negocioExistente) {
            Negocio negocioCadastrado = this.negocioRepository.findByCpfOrCnpj(
                    negocioSolicitado.getCpf(), negocioSolicitado.getCnpj()
            );

            if (negocioCadastrado.getAtivado()) {
                throw new EntidadeAtivadaException("Este negócio já está ativo");
            } else {
                System.out.println("Recuperar negócio?");
                return negocioCadastrado;
            }
        }
        return negocioSolicitado;
    }

    public Negocio cadastrar (Negocio negocioSolicitado, Usuario usuarioSolicitado) {
        Negocio negocioCadastro = verificarEstadoNegocio(negocioSolicitado);

        EstrategiaNegocio estrategiaNegocio = new EstrategiaNegocio();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaNegocio);
        factoryCampos.configurarCampos(negocioCadastro);

        estrategiaNegocio.configurarCampos(usuarioSolicitado, negocioSolicitado);

        return negocioRepository.save(negocioCadastro);
    }

    public List<Negocio> listar() {
        return negocioRepository.findAll();
    }

    public Negocio atualizar (@PathVariable UUID id, Negocio negocioSolicitado) {
        return negocioSolicitado;
    }

    public void deletar (@PathVariable UUID id) {
        Negocio negocioExistente = this.negocioRepository.findById(id).orElseThrow(()
                -> new EntidadeInexistenteException("Negócio não encontrado"));

        this.negocioRepository.deleteById(id);
    }
}
