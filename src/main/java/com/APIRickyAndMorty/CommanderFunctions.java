package com.APIRickyAndMorty;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CommanderFunctions {

    /**
     * Con esta función, facilitamos crear una configuración inicial de JCommander, pidiendo el nombre del
     * programa y un Supplier de tipo T para los argumentos. Así podemos usar alguna función que nos devuelva
     * un objeto que funcione como argumentos de JCommander
     * @param cliName           nombre que se mostrará en el CLI
     * @param argumentsSupplier función que devuelve un objeto de argumentos de JCommander
     * @param <T>               Tipo que se usará para los argumentos
     * @return una instancia de {@link JCommander} ya configurada con el nombre y los argumentos
     */
    static <T>JCommander buildCommanderWithName(String cliName, Supplier<T> argumentsSupplier) {
        JCommander jCommander = JCommander.newBuilder()
                .addObject(argumentsSupplier.get())
                .build();
        jCommander.setProgramName(cliName);
        return jCommander;
    }

    /**
     * Función utilizada para tomar los datos de JCommander, los argumentos esperados y en caso de que algo falle,
     * una función con el JCommander que generó el error
     */
    static Optional<List<Object>> parseArguments(JCommander jCommander, String[] arguments, Consumer<JCommander> onError) {
        try {
            jCommander.parse(arguments);
            return Optional.of(jCommander.getObjects());
        } catch (ParameterException paramExc) {
            onError.accept(jCommander);
        }

        return Optional.empty();
    }
}
