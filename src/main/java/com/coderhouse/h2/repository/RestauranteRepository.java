package com.coderhouse.h2.repository;

import com.coderhouse.h2.model.Restaurante;
import org.springframework.data.repository.CrudRepository;


public interface RestauranteRepository extends CrudRepository<Restaurante, Long>  {

    Restaurante findByNombre(String nombre);
}
