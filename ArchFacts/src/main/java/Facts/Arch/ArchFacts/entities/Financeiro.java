package Facts.Arch.ArchFacts.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Financeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "idFinanceiro", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idFinanceiro;
    private Double lucroTotal;
    private Double despesaTotal;
    private Double receita;
    private LocalDateTime dataCriacao;
    @OneToOne
    @JoinColumn (name = "fkProjeto", referencedColumnName = "idProjeto")
    Projeto projeto;

    public Financeiro() {
    }

    public Financeiro(UUID idFinanceiro, Double lucroTotal, Double despesaTotal, Double receita, LocalDateTime dataCriacao, Projeto projeto) {
        this.idFinanceiro = idFinanceiro;
        this.lucroTotal = lucroTotal;
        this.despesaTotal = despesaTotal;
        this.receita = receita;
        this.dataCriacao = dataCriacao;
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

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
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
                ", dataCriacao=" + dataCriacao +
                ", projeto=" + projeto +
                '}';
    }
}
