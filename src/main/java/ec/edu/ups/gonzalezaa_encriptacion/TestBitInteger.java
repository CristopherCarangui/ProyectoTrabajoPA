package ec.edu.ups.gonzalezaa_encriptacion;

import java.util.Arrays;
import java.util.List;

/**
 * @author Axel Gonzalez
 */
public class TestBitInteger {

    public static void main(String[] args) {
        List<Integer> mensaje = Arrays.asList(-1);
        String clave = "KEY";

        System.out.println("ALGORITMO POR BIT: lista de enteros");
        System.out.println("1- Datos de entrada");
        System.out.println("Texto original: " + mensaje);
        System.out.println("Clave: \"" + clave + "\"");
        System.out.println("2- Proceso");
        try {
            List<Integer> encriptado = Operaciones.encriptar(mensaje, clave,
                (m, c) -> Algoritmos.porBit(m, c));

        System.out.println("3- Salida");
        System.out.println(encriptado);
        } catch (NullPointerException e) {
            System.out.println("Error de clave: " + e.getMessage());
        }catch(IllegalArgumentException e1){
            System.out.println("Error: " + e1.getMessage());
        }
    }
}
