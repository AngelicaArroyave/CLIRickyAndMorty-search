package com.APIRickyAndMorty.api;

import com.APIRickyAndMorty.model.RickyAndMorty;
import feign.Headers;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

// Tipo de dato que devuelve la API: application/json
// Permite el consumo de la API
@Headers("Accept: application/json")
public interface APIRickyAndMorty {

    // Lista con los resultados que devuelve la petición a la API
    // La anotación permite saber cómo se debe hacer la petición web
    @RequestLine("GET /api/character/")
    RickyAndMorty getCharactersRickyAndMorty(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /api/location/")
    RickyAndMorty getLocationsRickyAndMorty(@QueryMap Map<String, Object> queryMap);

    @RequestLine("GET /api/episode/")
    RickyAndMorty getEpisodesRickyAndMorty(@QueryMap Map<String, Object> queryMap);
}
