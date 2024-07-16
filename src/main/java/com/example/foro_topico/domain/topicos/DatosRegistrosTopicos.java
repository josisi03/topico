package com.example.foro_topico.domain.topicos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistrosTopicos(@NotBlank String nombre, @NotBlank String mensaje, @NotBlank String curso, @NotBlank String titulo) {
    public DatosRegistrosTopicos(@NotBlank String nombre, @NotBlank String mensaje, @NotBlank String curso, @NotBlank String titulo) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.curso = curso;
        this.titulo = titulo;
    }

    public @NotBlank String nombre() {
        return this.nombre;
    }

    public @NotBlank String mensaje() {
        return this.mensaje;
    }

    public @NotBlank String curso() {
        return this.curso;
    }

    public @NotBlank String titulo() {
        return this.titulo;
    }
}
