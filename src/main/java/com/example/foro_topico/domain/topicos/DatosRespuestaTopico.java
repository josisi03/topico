package com.example.foro_topico.domain.topicos;

public record DatosRespuestaTopico(Long id, String nombre, String mensaje, String curso, String titulo) {
    public DatosRespuestaTopico(Long id, String nombre, String mensaje, String curso, String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.curso = curso;
        this.titulo = titulo;
    }

    public Long id() {
        return this.id;
    }

    public String nombre() {
        return this.nombre;
    }

    public String mensaje() {
        return this.mensaje;
    }

    public String curso() {
        return this.curso;
    }

    public String titulo() {
        return this.titulo;
    }
}
