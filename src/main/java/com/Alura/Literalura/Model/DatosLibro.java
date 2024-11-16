package com.Alura.Literalura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(

        @JsonAlias("id") long Id,

        @JsonAlias ("title") String titulo,

        @JsonAlias("authors") List <DatosAutor> autores,


        //@JsonAlias("languages") Idioma idioma,

        @JsonAlias("languages") List <String> idiomas,

        @JsonAlias ("download_count") int totalDescargas


) {
}
