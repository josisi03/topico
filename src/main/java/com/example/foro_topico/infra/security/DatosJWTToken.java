package com.example.foro_topico.infra.security;

public record DatosJWTToken(String jwTtoken) {
    public DatosJWTToken(String jwTtoken) {
        this.jwTtoken = jwTtoken;
    }

}
