package com.Alura.Literalura.Model;
import com.Alura.Literalura.Model.DatosAutor;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity (name ="Autor")
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

   String nombreAutor;

   Integer nacimiento;

    Integer fallecimiento;


    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {

        this.nombreAutor=datosAutor.nombreAutor();
        this.nacimiento= datosAutor.nacimiento();
        this.fallecimiento= datosAutor.fallecimiento();
    }

    public Autor(String nombreAutor, Integer nacimiento, Integer fallecimiento) {
        this.nombreAutor = nombreAutor;
        this.nacimiento = nacimiento;
        this.fallecimiento = fallecimiento;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public int getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "\n====================== AUTOR ======================" + '\n' +
                "Autor:  " + nombreAutor + '\n' +
                "Año de nascimento: " + (nacimiento != null ?  nacimiento.toString(): "Desconhecido") + '\n' +
                "Ano de falecimento: " + (fallecimiento != null ? fallecimiento.toString() : "Desconhecido") + '\n' +
                "Livros: " + libros.stream().map(b -> b.getTitulo()).collect(Collectors.toSet()) + '\n' +
                "===================================================";
    }
}
