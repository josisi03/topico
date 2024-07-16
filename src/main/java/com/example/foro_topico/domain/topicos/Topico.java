package com.example.foro_topico.domain.topicos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(
        name = "topicos"
)
@Entity(
        name = "Topico"
)
public class Topico {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String nombre;
    private String mensaje;
    private Boolean activo;
    private String curso;
    private String titulo;

    public Topico(DatosRegistrosTopicos datosRegistrosTopicos) {
        this.nombre = datosRegistrosTopicos.nombre();
        this.mensaje = datosRegistrosTopicos.mensaje();
        this.activo = true;
        this.curso = datosRegistrosTopicos.curso();
        this.titulo = datosRegistrosTopicos.titulo();
    }

    public Long getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public String getCurso() {
        return this.curso;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public Boolean getActivo() {
        return this.activo;
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.nombre() != null) {
            this.nombre = datosActualizarTopico.nombre();
        }

        if (datosActualizarTopico.mensaje() != null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }

        if (datosActualizarTopico.titulo() != null) {
            this.titulo = datosActualizarTopico.titulo();
        }

    }

    public void desactivarTopico() {
        this.activo = false;
    }

    public Topico() {
    }

    public Topico(final Long id, final String nombre, final String mensaje, final Boolean activo, final String curso, final String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.activo = activo;
        this.curso = curso;
        this.titulo = titulo;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Topico)) {
            return false;
        } else {
            Topico other = (Topico)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$id = this.getId();
                Object other$id = other.getId();
                if (this$id == null) {
                    if (other$id != null) {
                        return false;
                    }
                } else if (!this$id.equals(other$id)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Topico;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        return result;
    }
}

