package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
@Entity
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private LocalDate dataRegistro;
    private Boolean ativado;
    private Role role;
    @ManyToOne
    @JoinColumn(name = "fkNegocio")
    private Negocio negocio;

    public Usuario() {
    }

    public Usuario(UUID id, String nome, String email, String senha, String telefone, LocalDate dataRegistro,
                   Boolean ativado,
                   Role role,
                   Negocio negocio) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataRegistro = dataRegistro;
        this.ativado = ativado;
        this.role = role;
        this.negocio = negocio;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Boolean getAtivado() {
        return ativado;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", ativado=" + ativado +
                ", role=" + role +
                ", negocio=" + negocio +
                '}';
    }
}
