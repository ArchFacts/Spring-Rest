package Facts.Arch.ArchFacts.enumeration;

public enum Tipo {
    PROJETO("projeto"),
    CHAMADO("chamado"),
    TAREFA("tarefa");

    private String tipo;

    Tipo(String tipo) {
        this.tipo = tipo;
    }
}
