package Facts.Arch.ArchFacts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
    @Entity
    public class Negocio {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @JdbcTypeCode(SqlTypes.CHAR)
        @Column (name = "idNegocio", columnDefinition = "CHAR(36)")
        private UUID idNegocio;
        @NotBlank
        private String nome;
        private String codigo;
        private String cep;
        private String cpf;
        private String cnpj;
        private LocalDateTime dataRegistro;
        private Double avaliacao;
        private Boolean ativado;
        @OneToOne(mappedBy = "negocio", cascade = CascadeType.ALL)
        @JsonManagedReference
        private Endereco endereco;


        public Negocio() {
        }

        public Negocio(UUID idNegocio, String nome, String codigo, String cep, String cpf, String cnpj,
                       LocalDateTime dataRegistro,
                       Double avaliacao,
                       Boolean ativado,
                       Endereco endereco) {
            this.idNegocio = idNegocio;
            this.nome = nome;
            this.codigo = codigo;
            this.cep = cep;
            this.cpf = cpf;
            this.cnpj = cnpj;
            this.dataRegistro = dataRegistro;
            this.avaliacao = avaliacao;
            this.ativado = ativado;
            this.endereco = endereco;
        }

        public UUID getIdNegocio() {
            return idNegocio;
        }

        public void setIdNegocio(UUID idNegocio) {
            this.idNegocio = idNegocio;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
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

        public LocalDateTime getDataRegistro() {
            return dataRegistro;
        }

        public void setDataRegistro(LocalDateTime dataRegistro) {
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

        public Endereco getEndereco() {
            return endereco;
        }

        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }

        @Override
        public String toString() {
            return "Negocio{" +
                    "idNegocio=" + idNegocio +
                    ", nome='" + nome + '\'' +
                    ", codigo='" + codigo + '\'' +
                    ", cep='" + cep + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", cnpj='" + cnpj + '\'' +
                    ", dataRegistro=" + dataRegistro +
                    ", avaliacao=" + avaliacao +
                    ", ativado=" + ativado +
                    ", endereco=" + endereco +
                    '}';
        }
    }
