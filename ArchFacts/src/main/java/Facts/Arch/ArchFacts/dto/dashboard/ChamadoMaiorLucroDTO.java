package Facts.Arch.ArchFacts.dto.dashboard;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.UUID;

public class ChamadoMaiorLucroDTO {
    private UUID idChamado;
    private String titulo;
    private Double lucro;
    @Enumerated(EnumType.STRING)
    private Status status;

    public ChamadoMaiorLucroDTO() {
    }

    public ChamadoMaiorLucroDTO(UUID idChamado, String titulo, Double lucro) {
        this.idChamado = idChamado;
        this.titulo = titulo;
        this.lucro = lucro;
    }

    public UUID getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(UUID idChamado) {
        this.idChamado = idChamado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ChamadoMaiorLucroDTO{" +
                "idChamado=" + idChamado +
                ", titulo='" + titulo + '\'' +
                ", lucro=" + lucro +
                ", status=" + status +
                '}';
    }
}
