package Facts.Arch.ArchFacts.dto.chamado;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class ChamadoRequestDTO {
    private String titulo;
    private Double lucro;
    private LocalDateTime fechamento;

    @Enumerated
    private Status status;
    private String descricao;

    public ChamadoRequestDTO() {
    }

    public ChamadoRequestDTO(String titulo, Double lucro, LocalDateTime fechamento, Status status, String descricao) {
        this.titulo = titulo;
        this.lucro = lucro;
        this.fechamento = fechamento;
        this.status = status;
        this.descricao = descricao;
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

    public LocalDateTime getFechamento() {
        return fechamento;
    }

    public void setFechamento(LocalDateTime fechamento) {
        this.fechamento = fechamento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
