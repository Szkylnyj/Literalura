package com.Alura.Literalura;

import Service.ConsumoDeApi;
import Service.ConvierteDatos;
import com.Alura.Literalura.Bibloteca.Bibloteca;
import com.Alura.Literalura.Model.DatosLibro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoDeApi();

		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/?search=");

		ConvierteDatos conversor =new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosLibro.class);
		Bibloteca.menu();
		List<DatosLibro> datosLibros = new ArrayList<>();
		//for (int i = 0; i <= datos.; i++) {
			
		//}
		System.out.println(datos);
	}
}
