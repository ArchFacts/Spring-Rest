package facts.arch.ArchFacts.API.REST.entity;

import facts.arch.ArchFacts.API.REST.enums.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private Integer id;
    private String nome;
    private String descricao;
    private Double custo;
    private LocalDate dataInicio;
    private LocalDate dataEntrega;
    private Status status;
    List<Task> taskList = new ArrayList<>();
    List<Arquivo> arquivoList = new ArrayList<>();
    List<Ticket> ticketList = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(Integer id,
                   String nome,
                   String descricao,
                   Double custo,
                   LocalDate dataInicio,
                   LocalDate dataEntrega,
                   Status status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public List<Arquivo> getArquivoList() {
        return arquivoList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", custo=" + custo +
                ", dataInicio=" + dataInicio +
                ", dataEntrega=" + dataEntrega +
                ", status=" + status +
                ", taskList=" + taskList +
                ", arquivoList=" + arquivoList +
                ", ticketList=" + ticketList +
                '}';
    }
}
