package Facts.Arch.ArchFacts.dto.parcela;

import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParcelaRequestDTO {
    private Double valor;
    private LocalDateTime dataInicio;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer qtdParcelas;
    private UUID idChamado;
    private UUID idProjeto;

    public ParcelaRequestDTO() {
    }

    public ParcelaRequestDTO(Double valor, LocalDateTime dataInicio, Status status, Integer qtdParcelas,
                             UUID idChamado, UUID idProjeto) {
        this.valor = valor;
        this.dataInicio = dataInicio;
        this.status = status;
        this.qtdParcelas = qtdParcelas;
        this.idChamado = idChamado;
        this.idProjeto = idProjeto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public UUID getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(UUID idChamado) {
        this.idChamado = idChamado;
    }

    public UUID getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(UUID idProjeto) {
        this.idProjeto = idProjeto;
    }

    @Override
    public String toString() {
        return "ParcelaRequestDTO{" +
                "valor=" + valor +
                ", dataInicio=" + dataInicio +
                ", status=" + status +
                ", qtdParcelas=" + qtdParcelas +
                ", idChamado=" + idChamado +
                ", idProjeto=" + idProjeto +
                '}';
    }
}
