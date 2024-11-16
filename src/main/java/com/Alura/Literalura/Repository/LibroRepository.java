package com.Alura.Literalura.Repository;


import com.Alura.Literalura.Model.Idioma;
import com.Alura.Literalura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTituloContainingIgnoreCase(String libroTitulo);

    //List<Libro> findByIdioma(Idioma idioma);
    List<Libro> findByIdiomaContainingIgnoreCase(String idioma);

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List <Libro> listarLibrosPorIdioma (Idioma idioma);


}
