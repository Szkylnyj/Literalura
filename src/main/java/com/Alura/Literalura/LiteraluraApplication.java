package com.Alura.Literalura;

import com.Alura.Literalura.Principal.Principal;
import com.Alura.Literalura.Repository.AutorRepository;
import com.Alura.Literalura.Repository.LibroRepository;
import com.Alura.Literalura.Services.ConsumoDeApi;
import com.Alura.Literalura.Services.ConvierteDatos;
import com.Alura.Literalura.Model.DatosLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {




	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository libroRepository;


	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(libroRepository, autorRepository);
		principal.menuPrincipal();
	}
}
