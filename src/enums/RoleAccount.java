package enums;

public enum RoleAccount {
    ADMIN("ADMIN"),
    USER("USER");

    private String value;
    private RoleAccount(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }

    public static RoleAccount parseRole(String value) {
        RoleAccount[] values = values();
        for (RoleAccount role: values) {
            if(role.value.equals(value))
                return role;
        }
        throw new IllegalArgumentException("invalid");
    }
}
