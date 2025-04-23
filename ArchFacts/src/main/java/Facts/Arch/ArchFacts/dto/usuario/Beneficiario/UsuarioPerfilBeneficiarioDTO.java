package Facts.Arch.ArchFacts.dto.usuario.Beneficiario;

public class UsuarioPerfilBeneficiarioDTO {
    private String email;
    private String telefone;

    public UsuarioPerfilBeneficiarioDTO(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public UsuarioPerfilBeneficiarioDTO() {
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
}
