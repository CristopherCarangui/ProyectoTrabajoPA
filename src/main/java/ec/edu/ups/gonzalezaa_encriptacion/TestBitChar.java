package ec.edu.ups.gonzalezaa_encriptacion;

import java.util.Arrays;
import java.util.List;

/**
 * @author Axel Gonzalez
 */
public class TestBitChar {

    public static void main(String[] args) {
        List<Character> mensaje = Arrays.asList('H', 'o', 'L', 'A');
        String clave = "KEY";

        System.out.println("ALGORITMO POR BIT: lista de caracteres");
        System.out.println("1- Datos de entrada");
        String textoOriginal = "[";
        for (int i = 0; i < mensaje.size(); i++) {
            textoOriginal += "'" + mensaje.get(i) + "'";
            if (i < mensaje.size() - 1) {
                textoOriginal += ", ";
            }
        }
        textoOriginal += "]";
        System.out.println("Texto original: " + textoOriginal);
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
