package Facts.Arch.ArchFacts.dto.negocio;

public class NegocioRequestDTO {
    private String nome;
    private String cpfOrCnpj;
    private String cep;

    public NegocioRequestDTO() {
    }

    public NegocioRequestDTO(String nome, String cpfOrCnpj, String cep) {
        this.nome = nome;
        this.cpfOrCnpj = cpfOrCnpj;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}

