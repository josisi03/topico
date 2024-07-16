package com.example.foro_topico.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErrores {
    public TratadorDeErrores() {
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity tratarError404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity tratarError400(MethodArgumentNotValidException e) {
        List<DatosErrorValidacion> errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    private static record DatosErrorValidacion(String campo, String error) {
        public DatosErrorValidacion(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }

        private DatosErrorValidacion(String campo, String error) {
            this.campo = campo;
            this.error = error;
        }

        public String campo() {
            return this.campo;
        }

        public String error() {
            return this.error;
        }
    }
}
