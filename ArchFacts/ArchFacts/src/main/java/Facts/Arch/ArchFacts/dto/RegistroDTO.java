package Facts.Arch.ArchFacts.dto;

import Facts.Arch.ArchFacts.enums.Role;

public class RegistroDTO {
    private String email;
    private String senha;

    public RegistroDTO() {
    }

    public RegistroDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
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
}
