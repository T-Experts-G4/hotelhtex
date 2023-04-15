package br.com.htex.hotel.services;

public enum UsuarioRoles {
    ADMIN("ADMIN"),
    USUARIO("USUARIO");

    private final String role;

    UsuarioRoles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public static UsuarioRoles getEnum(String value) {
        for(UsuarioRoles v : values())
            if(v.getRole().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException();
    }
}
