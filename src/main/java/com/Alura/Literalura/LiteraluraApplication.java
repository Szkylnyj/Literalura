package com.Alura.Literalura;

import Service.ConsumoDeApi;
import Service.ConvierteDatos;
import com.Alura.Literalura.Model.DatosLibro;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {


	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		var consumoAPI = new ConsumoDeApi();

		var json = consumoAPI.obtenerDatos("gutendex.com/books");

		ConvierteDatos conversor =new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosLibro.class);
		System.out.println(datos);
	}
}
