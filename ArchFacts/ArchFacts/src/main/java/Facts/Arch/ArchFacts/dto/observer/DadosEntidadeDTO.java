package Facts.Arch.ArchFacts.dto.observer;

import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.entities.Tarefa;
import Facts.Arch.ArchFacts.enumeration.Status;
import Facts.Arch.ArchFacts.enumeration.Tipo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class DadosEntidadeDTO {
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Projeto projeto = null;
    private Negocio negocio = null;

    public DadosEntidadeDTO() {
    }

    public DadosEntidadeDTO(LocalDateTime dataInicio, LocalDateTime dataTermino, String descricao, Tipo tipo,
                            Status status, Projeto projeto, Negocio negocio) {
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = status;
        this.projeto = projeto;
        this.negocio = negocio;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    public static DadosEntidadeDTO setarDadosObserver(Object entidade) {
        DadosEntidadeDTO dto = new DadosEntidadeDTO();

        if (entidade instanceof Tarefa) {
            Tarefa tarefa = (Tarefa) entidade;
            dto.setDataInicio(tarefa.getDataInicio());
            dto.setDataTermino(tarefa.getDataTermino());
            dto.setDescricao(tarefa.getDescricao());
            dto.setTipo(Tipo.TAREFA);
            dto.setStatus(tarefa.getStatus());
            dto.setProjeto(tarefa.getProjeto());
            dto.setNegocio(tarefa.getProjeto().getNegocio());
        } else if (entidade instanceof Chamado) {
            Chamado chamado = (Chamado) entidade;
            dto.setDataInicio(chamado.getAbertura());
            dto.setDataTermino(chamado.getFechamento());
            dto.setDescricao(chamado.getDescricao());
            dto.setTipo(Tipo.CHAMADO);
            dto.setStatus(chamado.getStatus());
            dto.setProjeto(chamado.getProjeto());
            dto.setNegocio(chamado.getProjeto().getNegocio());
        } else if (entidade instanceof Projeto) {
            Projeto projeto = (Projeto) entidade;
            dto.setDataInicio(projeto.getDataInicio());
            dto.setDataTermino(projeto.getDataEntrega());
            dto.setDescricao(projeto.getDescricao());
            dto.setTipo(Tipo.PROJETO);
            dto.setStatus(projeto.getStatus());
            dto.setProjeto(projeto);
            dto.setNegocio(projeto.getNegocio());
        }

        return dto;
    }
}