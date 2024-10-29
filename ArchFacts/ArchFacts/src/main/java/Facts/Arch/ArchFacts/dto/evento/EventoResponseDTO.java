package Facts.Arch.ArchFacts.dto.evento;

import Facts.Arch.ArchFacts.enums.Prioridade;
import Facts.Arch.ArchFacts.enums.Status;
import Facts.Arch.ArchFacts.enums.Tipo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class EventoResponseDTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private String tempoRestante;
    private Prioridade prioridade;
    @Enumerated
    private Tipo tipo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    Status status;

    public EventoResponseDTO() {
    }

    public EventoResponseDTO(LocalDateTime dataInicio, LocalDateTime dataTermino, String tempoRestante,
                             Prioridade prioridade, Tipo tipo, String descricao, Status status) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.tempoRestante = tempoRestante;
        this.prioridade = prioridade;
        this.tipo = tipo;
        this.descricao = descricao;
        this.status = status;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(String tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
