package Facts.Arch.ArchFacts.dto.usuario.Prestador;

public class UsuarioPerfilPrestadorDTO {
    private String email;
    private String cpf;
    private String cnpj;
    private String telefone;

    public UsuarioPerfilPrestadorDTO() {
    }

    public UsuarioPerfilPrestadorDTO(String email, String cpf, String cnpj, String telefone) {
        this.email = email;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
