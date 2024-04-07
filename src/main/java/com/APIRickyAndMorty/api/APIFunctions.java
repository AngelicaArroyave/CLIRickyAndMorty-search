package com.APIRickyAndMorty.api;

import feign.Feign;
import feign.gson.GsonDecoder;

public interface APIFunctions {

    /**
     * Se encarga de generar un objeto de tipo API, es decir, un objeto que será consumido como una API
     *
     * @param api Es una clase de tipo T para construir la API
     * @param url Es la URL donde se están ejecutando las peticiones o request
     * @return
     * @param <T> Es el tipo de API
     */
    static <T> T buildAPI(Class<T> api, String url) {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(api, url);
    }
}
