package com.coderhouse.h2;

import com.coderhouse.h2.model.Category;
import com.coderhouse.h2.model.City;
import com.coderhouse.h2.model.Country;
import com.coderhouse.h2.model.Restaurante;
import com.coderhouse.h2.repository.RestauranteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class H2Application {

	public static void main(String[] args) {
		SpringApplication.run(H2Application.class, args);
	}

	@Bean
	public CommandLineRunner loadData(RestauranteRepository repository) {
		return (args) -> {
			repository.save(Restaurante.builder().nombre("Jose").ciudad(new City("BBAA", new Country("Arg"))).categorias(List.of(new Category("Verduleria"), new Category("DeLujo"))).build());
			repository.save(Restaurante.builder().nombre("Esteban").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().nombre("Juan").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().nombre("Matias").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().nombre("Nina").ciudad(new City("BBAA", new Country("Arg"))).build());
			repository.save(Restaurante.builder().nombre("Camila").ciudad(new City("BBAA", new Country("Arg"))).build());
		};
	}

	}