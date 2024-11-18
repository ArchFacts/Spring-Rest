package Facts.Arch.ArchFacts.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idFinanceiro;
    private Double lucroTotal;
    private Double despesaTotal;
    private Double receita;
    @OneToOne
    Projeto projeto;

    public Financeiro() {
    }

    public Financeiro(UUID idFinanceiro, Double lucroTotal, Double despesaTotal, Double receita, Projeto projeto) {
        this.idFinanceiro = idFinanceiro;
        this.lucroTotal = lucroTotal;
        this.despesaTotal = despesaTotal;
        this.receita = receita;
        this.projeto = projeto;
    }

    public UUID getIdFinanceiro() {
        return idFinanceiro;
    }

    public void setIdFinanceiro(UUID idFinanceiro) {
        this.idFinanceiro = idFinanceiro;
    }

    public Double getLucroTotal() {
        return lucroTotal;
    }

    public void setLucroTotal(Double lucroTotal) {
        this.lucroTotal = lucroTotal;
    }

    public Double getDespesaTotal() {
        return despesaTotal;
    }

    public void setDespesaTotal(Double despesaTotal) {
        this.despesaTotal = despesaTotal;
    }

    public Double getReceita() {
        return receita;
    }

    public void setReceita(Double receita) {
        this.receita = receita;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Financeiro{" +
                "idFinanceiro=" + idFinanceiro +
                ", lucroTotal=" + lucroTotal +
                ", despesaTotal=" + despesaTotal +
                ", receita=" + receita +
                ", projeto=" + projeto +
                '}';
    }
}
