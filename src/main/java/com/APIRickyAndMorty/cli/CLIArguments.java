package com.APIRickyAndMorty.cli;

import com.beust.jcommander.Parameter;
import lombok.Getter;

public class CLIArguments {

    /**
     * Constructor default para permitir que solo clases en el paquete puedan crear objetos de esta clase
     * De esta manera obligamos a que la construccion se haga mediante funciones publicas o builders
     * Las instancias deberán crearse mediante: CLIArguments#newInstance
     */
    CLIArguments() { }

    /**
     * Se crean las propiedades de búsqueda
     * Con @Parameter se da a entender que la propiedad puede ser enviada por la terminal
     */
    @Parameter(
            names = "--id",
            description = "Busca a un personaje de acuerdo al id"
    )
    private String id;

    @Parameter(
            names = {"--name", "-n"},
            description = "Busca de acuerdo al nombre de un personaje"
    )
    private String name;

    @Parameter(
            names = {"--status", "-st"},
            description = "Búsqueda dependiendo de palabras clave como Alive, Dead o unknown"
    )
    private String status;

    @Parameter(
            names = {"--species", "-sp"},
            description = "Búsqueda dependiendo de palabras clave como Human, Mythological Creature, Alien..."
    )
    private String species;

    @Parameter(
            names = {"--type", "-t"},
            description = "Busca los personajes por tipo o subespecies"
    )
    private String type;

    @Parameter(
            names = {"--gender", "-g"},
            description = "Búsqueda dependiendo de palabras clave como Female, Male, Genderless o unknown"
    )
    private String gender;

    @Parameter(
            names = "--help",
            help = true,
            validateWith = CLIHelpValidator.class,
            description = "Mostrar ayuda de los comandos"
    )
    private boolean isHelp;

    /**
     * Sirve como especie de supplier, de esta manera no se depende de un constructor
     */
    public static CLIArguments newInstance() {
        return new CLIArguments();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public String getGender() {
        return gender;
    }

    public boolean isHelp() {
        return isHelp;
    }

    @Override
    public String toString() {
        return "CLIArguments{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", isHelp=" + isHelp +
                '}';
    }
}
