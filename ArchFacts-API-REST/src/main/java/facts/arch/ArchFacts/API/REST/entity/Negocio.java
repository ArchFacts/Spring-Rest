package facts.arch.ArchFacts.API.REST.entity;

import java.util.ArrayList;
import java.util.List;

public class Negocio {
    private Integer id;
    private String nome;
    private String codigoNegocio;
    private String cpf;
    private String cnpj;
    List<Usuario> usuarioList = new ArrayList<>();
    List<Projeto> projetoList = new ArrayList<>();
    List<Mensagem> mensagemList = new ArrayList<>();

    public Negocio() {
    }

    public Negocio(Integer id,
                   String nome,
                   String codigoNegocio,
                   String cpf,
                   String cnpj) {
        this.id = id;
        this.nome = nome;
        this.codigoNegocio = codigoNegocio;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoNegocio() {
        return codigoNegocio;
    }

    public void setCodigoNegocio(String codigoNegocio) {
        this.codigoNegocio = codigoNegocio;
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

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public List<Projeto> getProjetoList() {
        return projetoList;
    }

    public List<Mensagem> getMensagemList() {
        return mensagemList;
    }

    @Override
    public String toString() {
        return "Negocio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoNegocio='" + codigoNegocio + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", usuarioList=" + usuarioList +
                ", projetoList=" + projetoList +
                ", mensagemList=" + mensagemList +
                '}';
    }
}
