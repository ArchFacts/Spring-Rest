package Facts.Arch.ArchFacts.entity;

import Facts.Arch.ArchFacts.enums.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class Usuario {
    private UUID idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private Role role;
    @ManyToOne
    @JoinColumn(name = "fkNegocio")
    private Negocio negocio;

}
