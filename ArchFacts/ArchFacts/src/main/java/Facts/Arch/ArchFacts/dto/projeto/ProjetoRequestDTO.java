package Facts.Arch.ArchFacts.dto.projeto;

import java.time.LocalDateTime;

public class ProjetoRequestDTO {
    private String nome;
    private String descricao;
    private LocalDateTime dataInicio;
    private LocalDateTime dataEntrega;

    public ProjetoRequestDTO() {
    }

    public ProjetoRequestDTO(String nome, String descricao, LocalDateTime dataInicio, LocalDateTime dataEntrega) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataEntrega = dataEntrega;
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

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
}
