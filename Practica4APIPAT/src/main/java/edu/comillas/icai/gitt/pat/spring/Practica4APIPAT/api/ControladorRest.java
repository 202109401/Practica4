package edu.comillas.icai.gitt.pat.spring.Practica4APIPAT.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/peliculas")
public class ControladorRest {
    private final Map<String, ModeloPelicula> peliculas = new HashMap<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloPelicula crearPelicula(@Valid @RequestBody ModeloPelicula pelicula, BindingResult result) {
        if (peliculas.containsKey(pelicula.titulo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La película ya existe");
        }
        if(result.hasErrors()) throw new ExcepcionPeliculaIncorrecta(result);
        peliculas.put(pelicula.titulo(), pelicula);
        return pelicula;
    }

    @GetMapping("/{titulo}")
    public ModeloPelicula getPelicula(@PathVariable String titulo) {
        ModeloPelicula pelicula = peliculas.get(titulo);
        if (pelicula == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La película no existe");
        }
        return pelicula;
    }

    @GetMapping
    public List<ModeloPelicula> getPeliculas() {
        return new ArrayList<>(peliculas.values());
    }

    @PutMapping("/{titulo}")
    public synchronized ModeloPelicula actualizarPelicula(@PathVariable String titulo,@Valid @RequestBody ModeloPelicula peliculaActualizada) {
        if (!peliculas.containsKey(titulo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La película no existe");
        }
        peliculas.put(titulo, peliculaActualizada);
        return peliculaActualizada;
    }

    @DeleteMapping("/{titulo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarPelicula(@PathVariable String titulo) {
        if (!peliculas.containsKey(titulo)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La película no existe");
        }
        peliculas.remove(titulo);
    }

    @ExceptionHandler(ExcepcionPeliculaIncorrecta.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ModeloCampoIncorrecto> contadorIncorrecto(ExcepcionPeliculaIncorrecta ex) {
        return ex.getErrores().stream().map(error -> new ModeloCampoIncorrecto(
                error.getDefaultMessage(), error.getField(), error.getRejectedValue()
        )).toList();
    }

}
