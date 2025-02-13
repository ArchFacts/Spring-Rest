package Facts.Arch.ArchFacts.enumeration;

public enum Prioridade {
    BAIXA("baixa"),
    MEDIA("média"),
    ALTA("alta");

    private String prioridade;

    Prioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public static Prioridade definirPrioridadeEvento(int diasRestantes) {
        if (diasRestantes < 1) {
            return Prioridade.ALTA;
        } else if (diasRestantes <= 3) {
            return Prioridade.MEDIA;
        } else {
            return  Prioridade.BAIXA;
        }
    }
}
