package Facts.Arch.ArchFacts.dto.dashboard;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public class TarefaMaiorDespesaDTO {
    private UUID idTarefa;
    private String titulo;
    private Double despesa;
    @Enumerated(EnumType.STRING)
    private Status status;

    public TarefaMaiorDespesaDTO() {
    }

    public TarefaMaiorDespesaDTO(UUID idTarefa, String titulo, Double despesa, Status status) {
        this.idTarefa = idTarefa;
        this.titulo = titulo;
        this.despesa = despesa;
        this.status = status;
    }

    public UUID getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(UUID idTarefa) {
        this.idTarefa = idTarefa;
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

    @Override
    public String toString() {
        return "TarefaMaiorDespesaDTO{" +
                "idTarefa=" + idTarefa +
                ", titulo='" + titulo + '\'' +
                ", despesa=" + despesa +
                ", status=" + status +
                '}';
    }
}
