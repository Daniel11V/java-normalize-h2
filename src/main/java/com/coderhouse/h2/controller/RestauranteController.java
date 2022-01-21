package com.coderhouse.h2.controller;

import com.coderhouse.h2.model.Restaurante;
import com.coderhouse.h2.service.RestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurante")
public class RestauranteController {

    private final RestauranteService restaurante;

    @PostMapping("/")
    public Restaurante createRestaurante(@RequestBody Restaurante newRestaurante) {
        return restaurante.createRestaurante(newRestaurante);
    }

    @PostMapping("/deserialize")
    public Map deserializeRestaurante(@RequestBody String restauranteString) throws JsonProcessingException {
        return restaurante.deserialize(restauranteString);
    }

    @GetMapping("/all")
    public List<Restaurante> findRestaurantes() {
        return restaurante.findAll();
    }

    @GetMapping("")
    public Restaurante findByName(@RequestParam String name) {
        return restaurante.findByName(name);
    }

    @PutMapping("/{id}")
    public Restaurante updateRestauranteById(@PathVariable Long id, @RequestBody  Restaurante newRestaurante) {
        return restaurante.updateRestauranteById(newRestaurante, id);
    }

}
