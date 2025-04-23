package Facts.Arch.ArchFacts.enumeration;

public enum Status {
    ABERTO("aberto"),
    PENDENTE("pendente"),
    PROGRESSO("progresso"),
    CONCLUIDO("concluído"),
    FECHADO("fechado"),
    PAGO("pago"),
    CANCELADO("cancelado");
    private String status;

    Status(String status) {
        this.status = status;
    }
}
