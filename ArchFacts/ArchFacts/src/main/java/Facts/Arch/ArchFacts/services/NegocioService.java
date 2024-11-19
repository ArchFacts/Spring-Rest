package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.exceptions.DocumentoInvalidoException;
import Facts.Arch.ArchFacts.exceptions.EntidadeAtivadaException;
import Facts.Arch.ArchFacts.exceptions.EntidadeInexistenteException;
import Facts.Arch.ArchFacts.repositories.NegocioRepository;
import Facts.Arch.ArchFacts.repositories.UsuarioRepository;
import Facts.Arch.ArchFacts.strategy.EstrategiaNegocio;
import Facts.Arch.ArchFacts.strategy.FactoryCampos;
import jakarta.servlet.http.HttpSession;
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
    private UsuarioLogadoService usuarioLogadoService;

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

    public String identificarTipoDocumento (String documento) {
        if (documento.length() == 11) {
            return "CPF";
        } else if (documento.length() == 14) {
            return "CNPJ";
        } else {
            throw new DocumentoInvalidoException("Seu documento não tem uma quantidade de caractéres válida");
        }
    }

    public Negocio criarNegocio(Negocio negocio) {
        Negocio negocioCadastro = negocio;

        verificarEstadoNegocio(negocioCadastro);

        EstrategiaNegocio estrategiaNegocio = new EstrategiaNegocio();
        FactoryCampos factoryCampos = new FactoryCampos(estrategiaNegocio);
        factoryCampos.configurarCampos(negocioCadastro);

        usuarioLogadoService.adicionarNegocioAoUsuario(negocioCadastro);
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
