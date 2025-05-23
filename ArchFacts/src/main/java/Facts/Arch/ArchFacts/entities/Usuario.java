package Facts.Arch.ArchFacts.entities;

import Facts.Arch.ArchFacts.enumeration.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    @Column(name = "idUsuario", columnDefinition = "varchar(36)")
    @JdbcTypeCode(SqlTypes.CHAR)
    private UUID idUsuario;
    @NotBlank
    @Schema(description = "Campo que representa o nome do usuário", example = "Diego")
    private String nome;
    //    @Email
    @Schema(description = "Campo que representa o email do usuário", example = "diego@gmail.com")
    private String email;
    @NotBlank
    @Schema(description = "Campo que representa o telefone do usuário", example = "Senha@123")
    private String senha;
    //    @Pattern(regexp = "(?:(^\\+\\d{2})?)(?:([1-9]{2})|([0-9]{3})?)(\\d{4,5}).?(\\d{4})",
//            message = "Número de telefone inválido")
    @Schema(description = "Campo que representa o telefone do usuário", example = "11-990304000")
    private String telefone;
    @Schema(description = "Campo que representa a data de registro que o usuário usuário", example = "2022-02-02 10:00:00")
    private LocalDateTime dataRegistro;
    @Schema(description = "Campo que representa se o usuário está ativo no sistema ", example = "true")
    private Boolean ativado;
    @Enumerated(EnumType.STRING)
    @Schema(description = "Campo que representa o papel do usuário no sistema", example = "user")
    private Role role;

    @ManyToOne
    @JoinColumn (name = "fkNegocio")
    private Negocio negocio;

    public Usuario() {
    }

    public Usuario(UUID id, String nome, String email, String senha, String telefone, LocalDateTime dataRegistro,
                   Boolean ativado,
                   Role role,
                   Negocio negocio) {
        this.idUsuario = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataRegistro = dataRegistro;
        this.ativado = ativado;
        this.role = role;
        this.negocio = negocio;
    }

    public Usuario(String nome, String email, String telefone, String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
    }

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Fazendo o Depara da nossa implementação com as roles do próprio Security
        if(this.role == Role.ADM) return List.of(new SimpleGrantedAuthority("ADM"),
                new SimpleGrantedAuthority("USER"));
        else return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + idUsuario +
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
