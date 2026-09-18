import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Programa3 {

    // Pide la cantidad de nombres para guardar en la lista y verifica que sean string
    public static void llenarLista(ArrayList<String> lista, Scanner entrada) {

        int cantidad;

        // Valida que el numero ingresado este entre 1 y 20
        while (true) {

            System.out.print("¿Cuántos nombres deseas agregar? ");

            // Comprueba si es un numero entero
            if (entrada.hasNextInt()) {

                cantidad = entrada.nextInt();

                // Sale del ciclo si el numero esta en el rango
                if (cantidad > 0 && cantidad <= 20) {
                    break;
                }

                System.out.println("La cantidad debe estar entre 1 y 20.");

            } else {

                // Descarta la entrada si no es un numero entero
                System.out.println("Debes ingresar un número entero.");
                entrada.next();
            }
        }

        // Limpia el salto de linea que queda en el scanner
        entrada.nextLine();

        // Pide los nombres uno por uno segun la cantidad indicada
        for (int i = 0; i < cantidad; i++) {

            String nombre;

            // Pide el nombre y verifica que no este vacio
            do {

                System.out.print("Ingresa el nombre " + (i + 1) + ": ");
                nombre = entrada.nextLine().trim();

                if (nombre.isEmpty()) {
                    System.out.println("El nombre no puede estar vacío.");
                }

            } while (nombre.isEmpty());

            // Agrega el nombre a la lista
            lista.add(nombre);
        }
    }

    // Muestra los nombres del ArrayList con for-each
    public static void mostrarArrayList(ArrayList<String> lista) {

        System.out.println("\n===== ARRAYLIST =====");

        for (String nombre : lista) {
            System.out.println(nombre);
        }
    }

    // Muestra los nombres del LinkedList con for-each
    public static void mostrarLinkedList(LinkedList<String> lista) {

        System.out.println("\n===== LINKEDLIST =====");

        for (String nombre : lista) {
            System.out.println(nombre);
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("===== PROGRAMA 3 =====");
        System.out.println("ArrayList + LinkedList + For-each\n");

        // Crea la lista ArrayList
        ArrayList<String> nombresArrayList = new ArrayList<>();

        // Llama al metodo para llenar el ArrayList
        llenarLista(nombresArrayList, entrada);

        // Muestra el ArrayList
        mostrarArrayList(nombresArrayList);

        // Crea la lista LinkedList
        LinkedList<String> nombresLinkedList = new LinkedList<>();

        // Copia los elementos del ArrayList al LinkedList
        nombresLinkedList.addAll(nombresArrayList);

        // Muestra el LinkedList
        mostrarLinkedList(nombresLinkedList);

        // Cierra el scanner
        entrada.close();
    }
}
