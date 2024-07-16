package com.example.foro_topico.domain.usuarios;

public record DatosAutentificacionDeUsuario(String login, String clave) {
    public DatosAutentificacionDeUsuario(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }

    public String login() {
        return this.login;
    }

    public String clave() {
        return this.clave;
    }
}
