package Facts.Arch.ArchFacts.dto.dashboard;

import java.time.LocalDateTime;

public class ResumoFinanceiroDTO {
    private Double lucroTotal;

    private Double despesaTotal;

    private Double receita;

    private LocalDateTime dataCriacao;


    public ResumoFinanceiroDTO(Double lucroTotal,
                               Double despesaTotal,
                               Double receita, LocalDateTime dataCriacao) {
        this.lucroTotal = lucroTotal;
        this.despesaTotal = despesaTotal;
        this.receita = receita;
        this.dataCriacao = dataCriacao;
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

    public ResumoFinanceiroDTO() {
    }

    @Override
    public String toString() {
        return "ResumoFinanceiroDTO{" +
                "lucroTotal=" + lucroTotal +
                ", despesaTotal=" + despesaTotal +
                ", receita=" + receita +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
