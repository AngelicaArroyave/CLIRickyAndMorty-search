package com.APIRickyAndMorty;

import com.APIRickyAndMorty.api.APIRickyAndMorty;
import com.APIRickyAndMorty.cli.CLIArguments;
import com.APIRickyAndMorty.cli.CLIFunctions;
import com.APIRickyAndMorty.model.RickyAndMorty;
import com.beust.jcommander.JCommander;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static com.APIRickyAndMorty.CommanderFunctions.buildCommanderWithName;
import static com.APIRickyAndMorty.CommanderFunctions.parseArguments;
import static com.APIRickyAndMorty.api.APIFunctions.buildAPI;

public class RickyAndMortySearch {

    private static final String CLI_NAME = "cliRickyAndMorty-search";
    private static final String BASE_URL_API = "https://rickandmortyapi.com";

    public static void main(String[] args) {
        // Crear el nuevo CLI
        JCommander jCommander = buildCommanderWithName(CLI_NAME, CLIArguments::newInstance);

        //Obtenemos las opciones que se le dieron a JCommander o por la terminal
        Stream<CLIArguments> streamOfCLI =
                //Nos retorna un Optional<List<Object>>, transformar la terminal en objeto de Jav
                parseArguments(jCommander, args, JCommander::usage)
                        //En caso de un Optional.empty()
                        .orElse(Collections.emptyList())
                        // La lista se convierte
                        .stream()
                        .map(obj -> (CLIArguments) obj);

        //Tomamos nuestro Stream y obtenemos las opciones que se dieron en el CLI
        Optional<CLIArguments> cliOptional = streamOfCLI
                //Solo nos interesan los casos donde no sea la solicitud de ayuda
                .filter(cli -> !cli.isHelp())
                .findFirst();

        //Si el Optional tiene un dato, lo convertimos a Map<String,Object>
        cliOptional.map(CLIFunctions::toMap)
                //Convertimos el Map en un request
                .map(RickyAndMortySearch::executeRequest)
                //Aun seguimos operando sobre un Optional… en caso de que no hubiera datos generamos un stream vacio
                .orElse(Stream.empty())
                //Imprimos los datos por pantalla
                .forEach(System.out::println);
    }

    private static Stream<RickyAndMorty> executeRequest(Map<String, Object> options) {
        APIRickyAndMorty api = buildAPI(APIRickyAndMorty.class, BASE_URL_API);

        return Stream.of(options)
                .map(api::getCharactersRickyAndMorty);
    }
}
