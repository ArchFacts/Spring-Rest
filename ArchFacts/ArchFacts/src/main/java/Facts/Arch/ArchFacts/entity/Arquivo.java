package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.Tipo;
import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class Arquivo {
    private UUID id;
    private String nome;
    private Tipo tipo;
    @ManyToOne
    @JoinColumn (name = "fkProjeto")
    private Projeto projeto;
    @OneToOne
    @JoinColumn (name = "fkUsuario")
    private Usuario usuario;
    public Arquivo() {
    }

    public Arquivo(UUID id, String nome, Tipo tipo, Projeto projeto) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.projeto = projeto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Arquivo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", projeto=" + projeto +
                '}';
    }
}
