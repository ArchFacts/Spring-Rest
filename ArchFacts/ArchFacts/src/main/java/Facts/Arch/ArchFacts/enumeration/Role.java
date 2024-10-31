package Facts.Arch.ArchFacts.enumeration;

public enum Role {
    USER("user"),
    EMPREGADO("empregado"),
    ADM("admin");
    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
