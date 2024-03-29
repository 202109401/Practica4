package edu.comillas.icai.gitt.pat.spring.Practica4APIPAT.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ExcepcionPeliculaIncorrecta extends RuntimeException {
    private List<FieldError> errores;
    public ExcepcionPeliculaIncorrecta(BindingResult result) {
        this.errores = result.getFieldErrors();
    }
    public List<FieldError> getErrores() {
        return errores;
    }
}