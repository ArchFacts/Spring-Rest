package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.MetodoPagamento;
import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.util.UUID;

public class Pagamento {
    private UUID id;
    private LocalDate data;
    private Double valorTotal;
    private Integer parcelas;
    private Integer parcelasPagas;
    private Status status;
    private MetodoPagamento metodoPagamento;
    @ManyToOne
    @JoinColumn (name = "fkTask")
    private Task task;
    @ManyToOne
    @JoinColumn (name = "fkUsuario")
    private Usuario usuario;

    public Pagamento() {
    }

    public Pagamento(UUID id, LocalDate data, Double valorTotal, Integer parcelas, Integer parcelasPagas, Status status,
                     MetodoPagamento metodoPagamento,
                     Task task,
                     Usuario usuario) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.parcelas = parcelas;
        this.parcelasPagas = parcelasPagas;
        this.status = status;
        this.metodoPagamento = metodoPagamento;
        this.task = task;
        this.usuario = usuario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public Integer getParcelasPagas() {
        return parcelasPagas;
    }

    public void setParcelasPagas(Integer parcelasPagas) {
        this.parcelasPagas = parcelasPagas;
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

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                ", parcelas=" + parcelas +
                ", parcelasPagas=" + parcelasPagas +
                ", status=" + status +
                ", metodoPagamento=" + metodoPagamento +
                ", task=" + task +
                ", usuario=" + usuario +
                '}';
    }
}
