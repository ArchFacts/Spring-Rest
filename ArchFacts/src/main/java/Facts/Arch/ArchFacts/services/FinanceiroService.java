package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.entities.Financeiro;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.FinanceiroRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class FinanceiroService {
    @Autowired
    private ProjetoRepository projetoRepository;
    @Autowired
    private FinanceiroRepository financeiroRepository;
    public Financeiro criarFinanceiro (UUID idProjeto) {
        Optional<Projeto> possivelProjeto = projetoRepository.findById(idProjeto);

        if (possivelProjeto.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um projeto");
        }

        Projeto projeto = possivelProjeto.get();

        Financeiro financeiro = new Financeiro();
        financeiro.setIdFinanceiro(null);
        financeiro.setLucroTotal(0.0);
        financeiro.setDespesaTotal(0.0);
        financeiro.setReceita(0.0);
        financeiro.setDataCriacao(LocalDateTime.now());
        financeiro.setProjeto(projeto);

        return financeiroRepository.save(financeiro);
    }

        public void atualizarReceita(Financeiro financeiro) {
            double receita = financeiro.getLucroTotal() - financeiro.getDespesaTotal();
            financeiro.setReceita(receita);
            financeiroRepository.save(financeiro);

    }
}
