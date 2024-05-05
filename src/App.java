import java.util.Scanner;

public class App {
    public static Scanner leer = new Scanner(System.in);
    public static int tamañoArreglo = 0;
    public static int arreglo[];

    public static void main(String[] args) throws Exception {

        boolean salida = true;
        boolean error = false;

        // Le pedimos al usuario que ingrese el tamaño del arreglo
        System.out.println("Ingrese el número de estudiantes.");
        tamañoArreglo = leer.nextInt();
        int arreglo[] = new int[tamañoArreglo];

        // Llenamos el arreglo
        do {
            try {
                System.out.println("Las edades deben estar entre 3 y 16.");
                error = false; // Reiniciamos la variable de error en cada iteración
                for (int i = 0; i < arreglo.length; i++) {
                    System.out.println("Ingrese la edad en la posición: " + (i + 1));
                    arreglo[i] = leer.nextInt();
                    if (arreglo[i] < 3 || arreglo[i] > 16) {
                        error = true;
                        break; // Salimos del bucle for si se encuentra un error
                    }
                }
                salida = error; // Solo cambiamos 'salida' a 'true' si hay un error
            } catch (Exception e) {
                System.out.println("Ingrese un número válido"+e);
                error = true; // Marcamos error en caso de excepción
            }
        } while (salida);

        // Mostramos el arreglo en la terminal
        System.out.println("----Edades desordeandas----");
        for (int i : arreglo) {
            System.out.println(i);
        }

        // Mostramos el arreglo ordenado
        System.out.println("-----Edades ordenadas-----");
        Ordenamiento(arreglo);
    }

    public static void Ordenamiento(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int key = arreglo[i]; // Seleccionamos el elemento a insertar en su posicion correcta
            int j = i - 1;
            // Movemos los elementos mayores que key a una posición adelantes de su posición
            // actual
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = key; // Insertamos key en su posición correcta
        }
        for (int i : arreglo) {
            System.out.println(i);
        }

        System.out.println("------------------------");
        // Imprimimos edades con clasificación de primaria o secundaria
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (arreglo[i] >= 11) {
                System.out.println(", está en secundaria");
            } else {
                System.out.println(", está en primaria");
            }
        }
    }
}
