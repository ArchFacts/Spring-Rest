package Facts.Arch.ArchFacts.dto.projeto;

import Facts.Arch.ArchFacts.entities.Usuario;
import Facts.Arch.ArchFacts.enumeration.Status;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class ProjetoResponseDTO {
    private String nome;
    private String descricao;
    private LocalDateTime dataEntrega;
    @Enumerated
    private Status status;
    private Usuario usuarioSolicitante;

    public ProjetoResponseDTO() {
    }

    public ProjetoResponseDTO(String nome, String descricao, LocalDateTime dataEntrega, Status status,
                              Usuario usuarioSolicitante) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.usuarioSolicitante = usuarioSolicitante;
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

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    @Override
    public String toString() {
        return "ProjetoResponseDTO{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", status=" + status +
                ", usuarioSolicitante=" + usuarioSolicitante +
                '}';
    }
}
