package Facts.Arch.ArchFacts.dto.empresasParceiras;

import java.time.LocalDateTime;

public class EmpresasParceirasResponseDTO {
    private String nomeEmpresa;
    private LocalDateTime dataRegistro;
    private Double avaliacao;

    public EmpresasParceirasResponseDTO() {
    }

    public EmpresasParceirasResponseDTO(String nomeEmpresa, LocalDateTime dataRegistro, Double avaliacao) {
        this.nomeEmpresa = nomeEmpresa;
        this.dataRegistro = dataRegistro;
        this.avaliacao = avaliacao;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
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

    @Override
    public String toString() {
        return "EmpresasParceirasResponseDTO{" +
                "nomeEmpresa='" + nomeEmpresa + '\'' +
                ", dataRegistro=" + dataRegistro +
                ", avaliacao=" + avaliacao +
                '}';
    }
}
