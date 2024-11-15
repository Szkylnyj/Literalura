package com.Alura.Literalura.Model;
import com.Alura.Literalura.Model.DatosAutor;

import jakarta.persistence.*;

import java.util.List;

@Entity (name ="Autor")
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

   String nombreAutor;

   int nacimiento;

   int fallecimiento;


    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor) {

        this.nombreAutor=datosAutor.nombreAutor();
        this.nacimiento= datosAutor.nacimiento();
        this.fallecimiento= datosAutor.fallecimiento();
    }

    public Autor(String nombreAutor, int nacimiento, int fallecimiento) {
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

    public void setNacimiento(int nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(int fallecimiento) {
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
        return "Autor{" +
                "Id=" + Id +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", nacimiento=" + nacimiento +
                ", fallecimiento=" + fallecimiento +
                ", libros=" + libros +
                '}';
    }
}
