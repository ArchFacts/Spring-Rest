package Facts.Arch.ArchFacts.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
    @Entity
    public class Negocio {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        @NotBlank
        private String nome;
        private String codigoNegocio;
        private String cep;
        @CPF
        private String cpf;
        @CNPJ
        private String cnpj;
        private LocalDate dataRegistro;
        private Double avaliacao;
        private Boolean ativado;
        @OneToOne(mappedBy = "negocio", cascade = CascadeType.ALL)
        @JsonManagedReference
        private Endereco endereco;

        @OneToMany(mappedBy = "negocio", cascade = CascadeType.ALL)
        @JsonIgnore
        List<Usuario> usuarioList = new ArrayList<>();
        @OneToMany(mappedBy = "negocio", cascade = CascadeType.ALL)
        @JsonIgnore
        List<Projeto> projetoList = new ArrayList<>();
        @OneToMany(mappedBy = "negocio", cascade = CascadeType.ALL)
        @JsonIgnore
        List<Mensagem> mensagemList = new ArrayList<>();

    public Negocio() {
    }

    public Negocio(UUID id, String nome, String codigoNegocio, String cep, String cpf, String cnpj,
                   LocalDate dataRegistro, Double avaliacao, Boolean ativado, Endereco endereco,
                   List<Usuario> usuarioList, List<Projeto> projetoList, List<Mensagem> mensagemList) {
            this.id = id;
            this.nome = nome;
            this.codigoNegocio = codigoNegocio;
            this.cep = cep;
            this.cpf = cpf;
            this.cnpj = cnpj;
            this.dataRegistro = dataRegistro;
            this.avaliacao = avaliacao;
            this.ativado = ativado;
            this.endereco = endereco;
            this.usuarioList = usuarioList;
            this.projetoList = projetoList;
            this.mensagemList = mensagemList;
        }

        public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Boolean getAtivado() {
        return ativado;
    }

    public void setAtivado(Boolean ativado) {
        this.ativado = ativado;
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

        public Endereco getEndereco() {
            return endereco;
        }

        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return "Negocio{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", codigoNegocio='" + codigoNegocio + '\'' +
                    ", cep='" + cep + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", cnpj='" + cnpj + '\'' +
                    ", dataRegistro=" + dataRegistro +
                    ", avaliacao=" + avaliacao +
                    ", ativado=" + ativado +
                    ", endereco=" + endereco +
                    ", usuarioList=" + usuarioList +
                    ", projetoList=" + projetoList +
                    ", mensagemList=" + mensagemList +
                    '}';
        }
    }
