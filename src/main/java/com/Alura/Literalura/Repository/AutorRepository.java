package com.Alura.Literalura.Repository;

import com.Alura.Literalura.Model.Autor;
import com.Alura.Literalura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Optional<Autor> findByNombreAutorContainingIgnoreCase(String nombreAutor);



    @Query("SELECT a FROM Autor a WHERE a.nacimiento <= :anio AND (a.fallecimiento IS NULL OR a.fallecimiento > :anio)")
    List<Autor> listarAutoresVivosEnAnio(Integer anio);



}
