package edu.comillas.icai.gitt.pat.spring.Practica4APIPAT.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ModeloPelicula(@NotBlank String titulo,@NotNull Integer año) { }
