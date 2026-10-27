package ec.edu.ups.gonzalezaa_encriptacion;

/**
 * @author Axel Gonzalez
 */
public class TestDesplazamiento {

    public static void main(String[] args) {
        String mensaje = "HOLA";
        Integer desplazamiento = 3;

        System.out.println("ALGORITMO POR DESPLAZAMIENTO");
        System.out.println("1- Datos de entrada");
        System.out.println("Texto original: \"" + mensaje + "\"");
        System.out.println("Desplazamiento: " + desplazamiento);
        System.out.println("2- Proceso");
        try {
            String encriptado = Operaciones.encriptar(mensaje, desplazamiento,
                (m, d) -> Algoritmos.porDesplazamiento(m, d));

            System.out.println("3- Salida");
            System.out.println("\"" + encriptado + "\"");
        } catch (IllegalArgumentException e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
