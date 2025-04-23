package Facts.Arch.ArchFacts.dto.tarefa;

import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class TarefaRequestDTO {
    private String titulo;
    private String descricao;
    private Double despesa;
    private LocalDateTime dataTermino;
    @Enumerated
    private Prioridade prioridade;
    @Enumerated
    private Status status;

    public TarefaRequestDTO() {
    }

    public TarefaRequestDTO(String titulo, String descricao, Double despesa, LocalDateTime dataTermino,
                            Prioridade prioridade, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.despesa = despesa;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getDespesa() {
        return despesa;
    }

    public void setDespesa(Double despesa) {
        this.despesa = despesa;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
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
}
