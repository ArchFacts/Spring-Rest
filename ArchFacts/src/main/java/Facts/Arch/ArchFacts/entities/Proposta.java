package Facts.Arch.ArchFacts.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "proposta")
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idProposta;
    private String titulo;
    private String cep;
    private LocalDateTime dataEntrega;
    private LocalDateTime dataEnvio;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "fkRemetente")
    private Usuario remetente;
    @ManyToOne
    @JoinColumn(name = "fkDestinatario")
    private Negocio destinatario;

    public Proposta() {
    }

    public Proposta(UUID idProposta,
                    String titulo,
                    String cep,
                    LocalDateTime dataEntrega,
                    LocalDateTime dataEnvio,
                    String endereco,
                    Integer numero,
                    String complemento,
                    String descricao,
                    Usuario remetente,
                    Negocio destinatario) {
        this.idProposta = idProposta;
        this.titulo = titulo;
        this.cep = cep;
        this.dataEntrega = dataEntrega;
        this.dataEnvio = dataEnvio;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.descricao = descricao;
        this.remetente = remetente;
        this.destinatario = destinatario;
    }

    public UUID getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(UUID idProposta) {
        this.idProposta = idProposta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Negocio getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Negocio destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Proposta{" +
                "idProposta=" + idProposta +
                ", titulo='" + titulo + '\'' +
                ", cep='" + cep + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", dataEnvio=" + dataEnvio +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", descricao='" + descricao + '\'' +
                ", remetente=" + remetente +
                ", destinatario=" + destinatario +
                '}';
    }
}
