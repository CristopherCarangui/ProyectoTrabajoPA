package ec.edu.ups.gonzalezaa_encriptacion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Axel Gonzalez
 */
public class Algoritmos {

    public static String porDesplazamiento(String mensaje, Integer desplazamiento) {
        String resultado = "";
        System.out.println("Letra Original\tDesplazamiento\tLetra encriptada");
        //Bucle de paso del pensale
        for (int i = 0; i < mensaje.length(); i++) {
            // Enciero de cada letra en char [ara cada letra del mensaje
            char letra = mensaje.charAt(i);
            //Excepcion
            if(letra< 'A'|| letra>'Z'){
                throw  new IllegalArgumentException("Caracter no valido: "+ letra+ " Solo se permiten letras Mayusculas");
            }
            //Encriptacion de cada letran en modo de las 26 letras del alfabeto y constancia para la letra 
            // por el despalzamiento
            char encriptada = (char) ('A' + (letra - 'A' + desplazamiento) % 26);
            System.out.println(letra + "\t\t+" + desplazamiento + "\t\t" + encriptada);
            //Salida de la letra encriptada 
            resultado = resultado + encriptada;
        }
        return resultado;
    }

    public static <T> List<Integer> porBit(List<T> mensaje, String clave) {
        //Verificacion para la clave de la encriptacion
        if (clave == null || clave.isEmpty()) {
            throw new IllegalArgumentException("La clave no puede ser nula ni vacia");
        }

        // Se crea la lista para pasar de letra a un numero binario
        List<Integer> valoresMensaje = new ArrayList<>();
        //Bucle en la lista para elemento de cada letra
        for (T elemento : mensaje) {
            if (elemento instanceof Character) {
                //Cambio de character a un valor 
                Character caracter = (Character) elemento;
                int valor = caracter;
                valoresMensaje.add(valor);
            } else if (elemento instanceof Integer) {
                //Casteo de un entero al elemento si es un integer
                valoresMensaje.add((Integer) elemento);
            } else {
                //Excepciones
                throw new IllegalArgumentException("Solo se permiten elementos Character o Integer (no nulos)");
            }
        }
        //SALIDA EN CONSOLA

        // Tabla del mensajes
        System.out.println("Caracter\tASCII\tBinario");
        for (int i = 0; i < mensaje.size(); i++) {
            System.out.println(mensaje.get(i) + "\t\t" + valoresMensaje.get(i) + "\t" + aBinario(valoresMensaje.get(i)));
        }
        System.out.println();

        // Tabla de Clave
        List<Integer> valoresClave = new ArrayList<>();
        System.out.println("Caracter de clave\tASCII\tBinario");
        for (int i = 0; i < mensaje.size(); i++) {
            char caracterClave = clave.charAt(i % clave.length());
            int valor = caracterClave;
            valoresClave.add(valor);
            System.out.println(caracterClave + "\t\t\t" + valor + "\t" + aBinario(valor));
        }
        System.out.println();

        // XOR entre el mensaje y la clave
        List<Integer> resultado = new ArrayList<>();
        System.out.println("resultado XOR\tRESULTADO");
        for (int i = 0; i < mensaje.size(); i++) {
            int xor = valoresMensaje.get(i) ^ valoresClave.get(i);
            resultado.add(xor);
            System.out.println(aBinario(xor) + "\t" + xor);
        }
        return resultado;
    }

    // Conversion de string a binario 
    private static String aBinario(int numero) {
        String binario = Integer.toBinaryString(numero);
        while (binario.length() < 7) {
            binario = "0" + binario;
        }
        return binario;
    }
}
