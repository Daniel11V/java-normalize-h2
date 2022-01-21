package com.coderhouse.h2.service;

import com.coderhouse.h2.model.Restaurante;
import com.coderhouse.h2.repository.RestauranteRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository repository;
    private final ObjectMapper mapper;

    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }

    @Override
    public Restaurante createRestaurante(Restaurante restaurante) {
        try {
            mapperToString(restaurante);
            mapperToMap(restaurante);
            mapperToClass(restaurante);

            return repository.save(restaurante);
        } catch (JsonProcessingException e) {
            log.error("Error converting message to string", e);
        }
        return restaurante;
    }

    @Override
    public Map deserialize(String restauranteString) throws JsonProcessingException  {
        return mapper.readValue(restauranteString, Map.class);
    }

    void mapperToString(Restaurante restaurante) throws JsonProcessingException {
        var restauranteString = mapper.writeValueAsString(restaurante);
        log.info("Mensaje en formato String : {}", restauranteString);
    }
    void mapperToMap(Restaurante restaurante) throws JsonProcessingException {
        var restauranteString = mapper.writeValueAsString(restaurante);
        var restauranteMap = mapper.readValue(restauranteString, Map.class);
        log.info("Mensaje en formato de Mapa : {}", restauranteMap);
    }

    void mapperToClass(Restaurante restaurante) throws JsonProcessingException {
        var restauranteString = mapper.writeValueAsString(restaurante);
        var restauranteClass = mapper.readValue(restauranteString, Restaurante.class);
        log.info("Mensaje en formato de Clase : {}", restauranteClass);
    }


    @Override
    public Restaurante getRestauranteById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Restaurante updateRestauranteById(Restaurante restaurante, Long id) {
        restaurante.setId(id);
        return repository.save(restaurante);
    }

    @Override
    public void delete(Restaurante restaurante, Long id) {
        restaurante.setId(id);
        repository.delete(restaurante);
    }

    @Override
    public Restaurante findByName(String name) {
        return repository.findByNombre(name);
    }

    @Override
    public List<Restaurante> findAll() {
        var restauranteList =  new ArrayList<Restaurante>();
        repository.findAll().forEach(restauranteList::add);
        return restauranteList;
    }
}
