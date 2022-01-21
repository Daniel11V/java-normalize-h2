package com.coderhouse.h2.service;

import com.coderhouse.h2.model.Restaurante;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface RestauranteService {

    Restaurante createRestaurante(Restaurante restaurante);
    Map deserialize(String restauranteString) throws JsonProcessingException;
    Restaurante getRestauranteById(Long id);
    Restaurante updateRestauranteById(Restaurante restaurante, Long id);
    void delete(Restaurante restaurante, Long id);
    Restaurante findByName(String name);
    List<Restaurante> findAll();

//    private static final Logger logger = LoggerFactory.getLogger(RestauranteService.class);
//    private ObjectMapper mapper = null;
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        mapper = new ObjectMapper();
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"));
//    }

}
