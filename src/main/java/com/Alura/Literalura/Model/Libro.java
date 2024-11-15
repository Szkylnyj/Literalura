package com.Alura.Literalura.Model;


import jakarta.persistence.*;

import java.util.List;


@Entity (name = "Libro")
@Table(name="libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

   private String titulo;

   @Enumerated(EnumType.STRING)
   private Idioma idioma;

   private int totalDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {
    }
    public Libro(DatosLibro datosLibro) {

        this.Id= datosLibro.Id();
        this.titulo= datosLibro.titulo();
        //this.idioma=datosLibro.idioma();
        this.totalDescargas=datosLibro.totalDescargas();
        this.autor=new Autor(datosLibro.autores().getFirst());
    }

    public Libro(String titulo, Idioma idioma, int totalDescargas, Autor autor) {
        this.titulo = titulo;
        this.idioma = idioma;
        this.totalDescargas = totalDescargas;
        this.autor = autor;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(int totalDescargas) {
        this.totalDescargas = totalDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "Id=" + Id +
                ", titulo='" + titulo + '\'' +
                ", idioma=" + idioma +
                ", totalDescargas=" + totalDescargas +
                ", autor=" + autor +
                '}';
    }
}
