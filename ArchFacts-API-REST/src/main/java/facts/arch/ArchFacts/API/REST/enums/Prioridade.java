package facts.arch.ArchFacts.API.REST.enums;

public enum Prioridade {
    BAIXA("baixa"),
    MEDIA("média"),
    ALTA("alta");

    private String prioridade;

    Prioridade(String prioridade) {
        this.prioridade = prioridade;
    }
}
