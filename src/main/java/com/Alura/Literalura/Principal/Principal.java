package com.Alura.Literalura.Principal;

import com.Alura.Literalura.Model.Idioma;
import com.Alura.Literalura.Repository.AutorRepository;
import com.Alura.Literalura.Repository.LibroRepository;
import com.Alura.Literalura.Services.ConsumoDeApi;
import com.Alura.Literalura.Services.ConvierteDatos;
import com.Alura.Literalura.Model.Autor;
import com.Alura.Literalura.Model.DatosLibro;
import com.Alura.Literalura.Model.Libro;
import com.Alura.Literalura.Services.RespuestaApi;

import java.util.*;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoDeApi consumoDeApi = new ConsumoDeApi();
    private final String URL = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository librorepository;
    private AutorRepository autorRepository;
    private RespuestaApi respuestaApi;


    public Principal(LibroRepository librorepository, AutorRepository autorRepository){
        this.librorepository=librorepository;
        this.autorRepository= autorRepository;

    }

    public void menuPrincipal(){

        var opcion =-1;
        while (opcion !=0){

            var menu = """
                    1 - Buscar Libros por Titulo
                    2 - Listar Libros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivos en un determinado Año
                    5 - Listar Libros por idiomas
                                                      
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion =scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4: listarAutoresVivosporAno();
                    break;
                case 5:
                    listarLibrosPorIdiomas();
                    break;
                case 0 :
                    System.out.println("Cerrando el programa..");
                    break;

            }
        }



    }

    private void agregarLibro() {
        Libro libro = buscarLibrosporTitulo();

        if (libro == null){
            System.out.println("No fue posibloe obtener ese libro a traves de la API");
        }else{
            Autor autor = libro.getAutor();

            if (estaRegistrado(libro.getTitulo())) {
                System.out.println("El libro buscado ya esta registrado en el Sistema.");
            }else{
                Autor autorEnBaseDeDatos = getAuthorOnDatabase(autor.getNombreAutor());

                if ( autorEnBaseDeDatos == null){
                    autorRepository.save(autor);
                }else{
                    libro.setAutor(autorEnBaseDeDatos);
                }

                librorepository.save(libro);
                System.out.println(libro);
            }
        }
    }

    private Libro buscarLibrosporTitulo() {

        System.out.println("Escribe el nombre del libro que deseas buscar:");
        var tituloLibro = scanner.nextLine();
        var apiURL = URL + tituloLibro.replace(" ", "%20");
        var json = consumoDeApi.obtenerDatos(apiURL);
            respuestaApi = conversor.obtenerDatos(json, RespuestaApi.class);
            Optional<DatosLibro> libroBuscado = respuestaApi.datosLibros().stream().findFirst();
            if (libroBuscado.isPresent()) {
                DatosLibro datosLibro = libroBuscado.get();
                return new Libro(datosLibro);
            }

        return null;
    }

    private void listarLibrosRegistrados() {

        List<Libro> libros = librorepository.findAll();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            libros.stream()
                    .sorted(Comparator.comparing(Libro::getTitulo))
                    .forEach(System.out::println);
        }

    }
    private boolean estaRegistrado(String libroTitulo){
        Optional<Libro> libro = librorepository.findByTituloContainingIgnoreCase(libroTitulo);
        return libro.isPresent();
    }

    private void listarAutoresRegistrados() {

        List<Autor> autores = autorRepository.findAll();
        if (autores.isEmpty()) {
            System.out.println("No hay autores registrados.");
        } else {
            autores.forEach(a -> System.out.printf(
                    "Autor: %s | Nacimiento: %d | Fallecimiento: %s\n",
                    a.getNombreAutor(),
                    a.getNacimiento(),
                    (a.getFallecimiento() == 0 ? "Vivo" : a.getFallecimiento())
            ));
        }

    }
    private Autor getAuthorOnDatabase(String autorNombre){
        Optional<Autor> autor = autorRepository.findByNombreAutorContainingIgnoreCase(autorNombre);
        return autor.orElse(null);
    }

    private void listarAutoresVivosporAno() {
        System.out.println("Escribe el año que deseas buscar:");
        try {
            int anio = Integer.parseInt(scanner.nextLine());
            List<Autor> autoresVivos = autorRepository.listarAutoresVivosEnAnio(anio);
            if (autoresVivos.isEmpty()) {
                System.out.println("No se encontraron autores vivos en el año " + anio);
            } else {
                autoresVivos.forEach(a -> System.out.printf(
                        "Autor: %s | Nacimiento: %d\n",
                        a.getNombreAutor(),
                        a.getNacimiento()
                ));
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un año válido.");
        }
    }
    private void listarLibrosPorIdiomas() {
        var menu = """
            Ingrese el idioma para buscar los libros:
            es - Español
            en - Inglés
            fr - Francés
            pt - Portugués
            """;
        System.out.println(menu);



        System.out.println("Escriba el idioma del libro que desea buscar");
        var idioma = scanner.nextLine();

        List<Libro> libros = librorepository.findByIdiomaContainingIgnoreCase(idioma);

        if (libros.isEmpty()){
            System.out.println("No se encontraron libros en ese Idioma.");
        }else{
            libros.forEach(System.out::println);
            System.out.println("Total de libros encontrados: " + libros.size());
        }




    }








}
