package Facts.Arch.ArchFacts.dto.negocio;

public class NegocioRequestDTO {
    private String nome;
    private String CpforCnpj;
    private String Cep;

    public NegocioRequestDTO() {
    }

    public NegocioRequestDTO(String nome, String cpforCnpj, String cep) {
        this.nome = nome;
        CpforCnpj = cpforCnpj;
        Cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpforCnpj() {
        return CpforCnpj;
    }

    public void setCpforCnpj(String cpforCnpj) {
        CpforCnpj = cpforCnpj;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }
}

