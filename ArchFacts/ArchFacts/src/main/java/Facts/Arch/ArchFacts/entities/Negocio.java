package Facts.Arch.ArchFacts.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.v3.oas.annotations.media.Schema;
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
        @Schema(description = "Campo que representa o nome do negócio", example = "Data-RE")
        private String nome;
        @Schema(description = "Campo que representa o código do negócio", example = "202020")
        private String codigo;
        @Schema(description = "Campo que representa o CEP do negócio", example = "06315040")
        private String cep;
        @Schema(description = "Campo que representa o CPF do negócio", example = "45840168681")
        private String cpf;
        @Schema(description = "Campo que representa o CNPJ do negócio", example = "05720367/0001-01")
        private String cnpj;
        @Schema(description = "Campo que representa a data de registro do negócio", example = "2020-10-10")
        private LocalDateTime dataRegistro;
        @Schema(description = "Campo que representa a nota de avaliação do negócio", example = "4.5")
        private Double avaliacao;
        @Schema(description = "Campo que representa se o negócio está ativado", example = "true")
        private Boolean ativado;
//        @OneToOne(mappedBy = "negocio", cascade = CascadeType.ALL)
//        @JsonManagedReference
//        private Endereco endereco;


        public Negocio() {
        }

        public Negocio(UUID idNegocio, String nome, String codigo, String cep, String cpf, String cnpj,
                       LocalDateTime dataRegistro,
                       Double avaliacao,
                       Boolean ativado) {
            this.idNegocio = idNegocio;
            this.nome = nome;
            this.codigo = codigo;
            this.cep = cep;
            this.cpf = cpf;
            this.cnpj = cnpj;
            this.dataRegistro = dataRegistro;
            this.avaliacao = avaliacao;
            this.ativado = ativado;
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
                    '}';
        }
    }
