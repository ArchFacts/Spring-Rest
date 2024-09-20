package Facts.Arch.ArchFacts.dto;

public class RespostaUsuarioDTO {
    private String nome;
    private String email;
    private String telefone;
    private RespostaUsuarioDTO respostaUsuarioDTO;

    public RespostaUsuarioDTO() {
    }

    public RespostaUsuarioDTO(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
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

    public RespostaUsuarioDTO getUsuarioDTO() {
        return respostaUsuarioDTO;
    }

    public void setUsuarioDTO(RespostaUsuarioDTO respostaUsuarioDTO) {
        this.respostaUsuarioDTO = respostaUsuarioDTO;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
