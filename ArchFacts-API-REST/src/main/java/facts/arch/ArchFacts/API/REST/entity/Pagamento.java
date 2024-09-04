package facts.arch.ArchFacts.API.REST.entity;

import facts.arch.ArchFacts.API.REST.enums.MetodoPagamento;
import facts.arch.ArchFacts.API.REST.enums.Status;

import java.time.LocalDate;

public class Pagamento {
    private Integer id;
    private LocalDate data;
    private Double valor;
    private Status status;
    private MetodoPagamento metodoPagamento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", data=" + data +
                ", valor=" + valor +
                ", status=" + status +
                ", metodoPagamento=" + metodoPagamento +
                '}';
    }
}
