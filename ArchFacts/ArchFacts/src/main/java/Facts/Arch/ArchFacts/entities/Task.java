package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Prioridade prioridade;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "fkProjeto")
    Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "fkPagamento")
    Pagamento pagamento;

//    @ManyToOne
//    @JoinColumn(name = "fkTicket")
//    Ticket ticket;
    @OneToMany (mappedBy = "task", cascade = CascadeType.ALL)
    List<Pagamento> pagamentoList = new ArrayList<>();

    public Task() {
    }

    public Task(UUID id, String descricao, LocalDate dataInicio, LocalDate dataTermino,
                Prioridade prioridade, Status status, Projeto projeto, Pagamento pagamento,
                List<Pagamento> pagamentoList) {
        this.id = id;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.status = status;
        this.projeto = projeto;
        this.pagamento = pagamento;
        this.pagamentoList = pagamentoList;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public List<Pagamento> getPagamentoList() {
        return pagamentoList;
    }

    public void setPagamentoList(List<Pagamento> pagamentoList) {
        this.pagamentoList = pagamentoList;
    }

    //    public List<Pagamento> getPagamentoList() {
//        return pagamentoList;
//    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", projeto=" + projeto +
                ", pagamento=" + pagamento +
                ", pagamentoList=" + pagamentoList +
                '}';
    }
}
