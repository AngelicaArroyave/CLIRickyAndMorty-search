package com.APIRickyAndMorty.cli;

import java.util.HashMap;
import java.util.Map;

public class CLIFunctions {

    /**
     * Funcion que tomará los argumentos del CLI y los convertirá en algo que se pueda usar en la API de Ricky y Morty
     */
    public static Map<String, Object> toMap(CLIArguments cliArguments) {
        Map<String, Object> params = new HashMap<>();

        params.put("id", cliArguments.getId());
        params.put("name", cliArguments.getName());
        params.put("status", cliArguments.getStatus());
        params.put("species", cliArguments.getSpecies());
        params.put("type", cliArguments.getType());
        params.put("gender", cliArguments.getGender());
        params.put("page", cliArguments.getPage());

        return params;
    }
}
