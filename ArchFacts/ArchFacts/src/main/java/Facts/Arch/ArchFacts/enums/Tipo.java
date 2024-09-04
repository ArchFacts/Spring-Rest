package Facts.Arch.ArchFacts.enums;

public enum Tipo {
    RELATORIO("relatorio"),
    DOCUMENTO("documento"),
    CONTRATO("contrato");

    private String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }
}
