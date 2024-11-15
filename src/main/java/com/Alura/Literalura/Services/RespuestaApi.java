package com.Alura.Literalura.Services;

import com.Alura.Literalura.Model.DatosLibro;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaApi(@JsonAlias("results") List<DatosLibro> datosLibros){}