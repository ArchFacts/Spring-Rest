package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Entity
public class Projeto {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private Double custo;
    private LocalDate dataInicio;
    private LocalDate dataEntrega;
    private Status status;
    @ManyToOne
    @JoinColumn (name = "fkNegocio")
    Negocio negocio;
    @ManyToOne
    @JoinColumn (name = "fkDestinatario")
    Usuario destinatario;
    @OneToMany (mappedBy = "projeto", cascade = CascadeType.ALL)
    List<Task> taskList = new ArrayList<>();
    @OneToMany (mappedBy = "projeto", cascade = CascadeType.ALL)
    List<Arquivo> arquivoList = new ArrayList<>();
    @OneToMany (mappedBy = "projeto", cascade = CascadeType.ALL)
    List<Ticket> ticketList = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(UUID id, String nome, String descricao, Double custo, LocalDate dataInicio, LocalDate dataEntrega,
                   Status status,
                   Negocio negocio,
                   Usuario destinatario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.negocio = negocio;
        this.destinatario = destinatario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
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
                ", negocio=" + negocio +
                ", destinatario=" + destinatario +
//                ", taskList=" + taskList +
//                ", arquivoList=" + arquivoList +
//                ", ticketList=" + ticketList +
                '}';
    }
}
