package Facts.Arch.ArchFacts.dto.projeto;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Usuario;

import java.time.LocalDateTime;

public class ProjetoRequestDTO {
    private String nome;
    private String descricao;
    private LocalDateTime dataEntrega;
    private Usuario usuarioSolicitante;
    private Negocio negocioDestinado;

    public ProjetoRequestDTO() {
    }

    public ProjetoRequestDTO(String nome, String descricao, LocalDateTime dataEntrega,
                             Usuario usuarioSolicitante, Negocio negocioDestinado) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
        this.usuarioSolicitante = usuarioSolicitante;
        this.negocioDestinado = negocioDestinado;
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

    public Usuario getUsuarioSolicitante() {
        return usuarioSolicitante;
    }

    public void setUsuarioSolicitante(Usuario usuarioSolicitante) {
        this.usuarioSolicitante = usuarioSolicitante;
    }

    public Negocio getNegocioDestinado() {
        return negocioDestinado;
    }

    public void setNegocioDestinado(Negocio negocioDestinado) {
        this.negocioDestinado = negocioDestinado;
    }
}
