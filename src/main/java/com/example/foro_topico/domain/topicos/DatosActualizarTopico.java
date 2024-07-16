package com.example.foro_topico.domain.topicos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull Long id, String nombre, String mensaje, String titulo) {
    public DatosActualizarTopico(@NotNull Long id, String nombre, String mensaje, String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.titulo = titulo;
    }

    public @NotNull Long id() {
        return this.id;
    }

    public String nombre() {
        return this.nombre;
    }

    public String mensaje() {
        return this.mensaje;
    }

    public String titulo() {
        return this.titulo;
    }
}

