package ec.edu.ups.gonzalezaa_encriptacion;

import java.util.function.BiFunction;

/**
 * Clase con el método genérico que ejecuta cualquier algoritmo de encriptación.
 *
 * @author Axel Gonzalez
 */
public class Operaciones {
    //Creacion del metodo generico
    public static <T, U, R> R encriptar(T mensaje, U clave, BiFunction<T, U, R> operacion) {
        return operacion.apply(mensaje, clave);
    }
}
