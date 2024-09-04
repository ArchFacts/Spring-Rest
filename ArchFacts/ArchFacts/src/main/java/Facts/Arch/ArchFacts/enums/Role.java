package Facts.Arch.ArchFacts.enums;

public enum Role {
    USER("user"),
    EMPREGADO("empregado"),
    ADMINISTRADOR("administrador");
    private String role;

    Role(String role) {
        this.role = role;
    }
}
