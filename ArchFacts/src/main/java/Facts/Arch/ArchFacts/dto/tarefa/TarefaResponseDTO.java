package Facts.Arch.ArchFacts.dto.tarefa;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class TarefaResponseDTO {
    private String titulo;
    private Double despesa;
    @Enumerated
    private Status status;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataTermino;

    public TarefaResponseDTO() {
    }

    public TarefaResponseDTO(String titulo, Double despesa, Status status, LocalDateTime dataAbertura,
                             LocalDateTime dataTermino) {
        this.titulo = titulo;
        this.despesa = despesa;
        this.status = status;
        this.dataAbertura = dataAbertura;
        this.dataTermino = dataTermino;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getDespesa() {
        return despesa;
    }

    public void setDespesa(Double despesa) {
        this.despesa = despesa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {
        return "TarefaResponseDTO{" +
                "titulo='" + titulo + '\'' +
                ", despesa=" + despesa +
                ", status=" + status +
                ", dataAbertura=" + dataAbertura +
                ", dataTermino=" + dataTermino +
                '}';
    }
}
