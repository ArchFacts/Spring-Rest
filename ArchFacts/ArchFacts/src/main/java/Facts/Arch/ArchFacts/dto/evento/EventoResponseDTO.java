package Facts.Arch.ArchFacts.dto.evento;

import Facts.Arch.ArchFacts.entities.Evento;
import Facts.Arch.ArchFacts.enumeration.Prioridade;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.enumeration.Tipo;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventoResponseDTO {
    Tipo tipo;
    private String descricao;
    LocalDateTime dataCriacao;
    LocalDateTime dataEncerramento;
    Status status;
    Prioridade prioridade;
    String nomeProjeto;
    String nomeNegocio;

    public EventoResponseDTO() {
    }

    public EventoResponseDTO(Tipo tipo,
                             String descricao,
                             LocalDateTime dataCriacao,
                             LocalDateTime dataEncerramento,
                             Status status,
                             Prioridade prioridade,
                             String nomeProjeto,
                             String nomeNegocio) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataEncerramento = dataEncerramento;
        this.status = status;
        this.prioridade = prioridade;
        this.nomeProjeto = nomeProjeto;
        this.nomeNegocio = nomeNegocio;
    }
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getNomeNegocio() {
        return nomeNegocio;
    }

    public void setNomeNegocio(String nomeNegocio) {
        this.nomeNegocio = nomeNegocio;
    }

    @Override
    public String toString() {
        return "EventoResponseDTO{" +
                "tipo=" + tipo +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                ", dataEncerramento=" + dataEncerramento +
                ", status=" + status +
                ", prioridade=" + prioridade +
                ", nomeProjeto='" + nomeProjeto + '\'' +
                ", nomeNegocio='" + nomeNegocio + '\'' +
                '}';
    }
}
