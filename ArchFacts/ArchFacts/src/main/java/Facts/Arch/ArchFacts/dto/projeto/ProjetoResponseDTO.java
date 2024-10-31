package Facts.Arch.ArchFacts.dto.projeto;

import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class ProjetoResponseDTO {
    private String nome;
    private String descricao;
    private Double custo;
    private LocalDateTime dataEntrega;
    @Enumerated
    private Status status;

    public ProjetoResponseDTO() {
    }

    public ProjetoResponseDTO(String nome, String descricao, Double custo, LocalDateTime dataEntrega, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.dataEntrega = dataEntrega;
        this.status = status;
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

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
