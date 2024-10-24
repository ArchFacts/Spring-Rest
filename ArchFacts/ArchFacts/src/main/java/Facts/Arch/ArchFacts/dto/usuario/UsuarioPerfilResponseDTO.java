package Facts.Arch.ArchFacts.dto.usuario;

import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.enums.Role;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public class UsuarioPerfilResponseDTO {
    private String nome;
    private String email;
    private String telefone;
    private LocalDateTime dataRegistro;
    private Boolean ativado;
    private Role role;
    private Negocio negocio;

    public UsuarioPerfilResponseDTO() {
    }

    public UsuarioPerfilResponseDTO(String nome, String email, String telefone, LocalDateTime dataRegistro,
                                    Boolean ativado, Role role, Negocio negocio) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataRegistro = dataRegistro;
        this.ativado = ativado;
        this.role = role;
        this.negocio = negocio;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
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
    public void setNegocio(String s) {
    }

    @Override
    public String toString() {
        return "UsuarioPerfilResponseDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", ativado=" + ativado +
                ", role=" + role +
                ", negocio='" + negocio + '\'' +
                '}';
    }
}
