package Facts.Arch.ArchFacts.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idServico;
    private String nome;
    private String descricao;
    @ManyToOne
    Negocio negocio;

    public Servico() {
    }

    public Servico(UUID idServico, String nome, String descricao, Negocio negocio) {
        this.idServico = idServico;
        this.nome = nome;
        this.descricao = descricao;
        this.negocio = negocio;
    }

    public UUID getIdServico() {
        return idServico;
    }

    public void setIdServico(UUID idServico) {
        this.idServico = idServico;
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

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "idServico=" + idServico +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", negocio=" + negocio +
                '}';
    }
}
