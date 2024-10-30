package com.Alura.Literalura;

import Service.ConsumoDeApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
		var consumoAPI = new ConsumoDeApi();

		var json = consumoAPI.obtenerDatos("https://gutendex.com/");
		System.out.println(json);
	}

}
