package Facts.Arch.ArchFacts.dto.chamado;

import java.util.UUID;

public class ChamadoLucroResponseDTO {
    private UUID idChamado;
    private Double lucro;

    public ChamadoLucroResponseDTO() {
    }

    public ChamadoLucroResponseDTO(UUID idChamado, Double lucro) {
        this.idChamado = idChamado;
        this.lucro = lucro;
    }

    public UUID getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(UUID idChamado) {
        this.idChamado = idChamado;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    @Override
    public String toString() {
        return "ChamadoLucroResponseDTO{" +
                "idChamado=" + idChamado +
                ", lucro=" + lucro +
                '}';
    }
}
