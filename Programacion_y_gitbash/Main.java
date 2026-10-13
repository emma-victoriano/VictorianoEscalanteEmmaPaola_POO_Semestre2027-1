import java.util.Scanner;

public class Main {

    // Permite leer los datos del usuario
    private static final Scanner entrada =
            new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("CATALOGO DE LENGUAJES");
        System.out.println("Ingresa los datos solicitados: ");

        // Registro del lenguaje C
        System.out.println("\n Datos del lenguaje C: ");

        String nombreC = leerTexto("Nombre: ");
        int anioC = leerEnteroPositivo("Año de creacion: ");
        String paradigmaC = leerTexto("Paradigma: ");
        String caracteristicaC = leerTexto("Caracteristica: ");

        C lenguajeC = new C(
                nombreC, anioC, paradigmaC, caracteristicaC
        );

        // Registro del lenguaje Python.
        System.out.println("\n Datos del lenguaje Python");

        String nombrePython = leerTexto("Nombre: ");
        int anioPython = leerEnteroPositivo("Año de creacion: ");
        String paradigmaPython = leerTexto("Paradigma: ");
        String caracteristicaPython = leerTexto("Caracteristica: ");

        Python lenguajePython = new Python(
                nombrePython, anioPython,
                paradigmaPython, caracteristicaPython
        );

        // Registro del lenguaje Java.
        System.out.println("\n Datos del lenguaje Java");

        String nombreJava = leerTexto("Nombre: ");
        int anioJava = leerEnteroPositivo("Año de creacion: ");
        String paradigmaJava = leerTexto("Paradigma: ");
        String caracteristicaJava = leerTexto("Caracteristica: ");

        Java lenguajeJava = new Java(
                nombreJava, anioJava,
                paradigmaJava, caracteristicaJava
        );

        // Demostracion de la herencia simple.
        System.out.println("\n HERENCIA SIMPLE");
        lenguajeC.mostrarInformacion();
        lenguajeC.mostrarCaracteristica();

        // Demostracion de la herencia con super.
        System.out.println("\nHERENCIA CON SUPER");
        lenguajePython.mostrarInformacion();
        lenguajePython.mostrarCaracteristica();

        // Demostracion de la sobrescritura.
        System.out.println("\nHERENCIA CON OVERRIDE");
        lenguajeJava.mostrarInformacion();

        // Demostracion de la sobrecarga.
        System.out.println("\nSOBRECARGA");

        System.out.println("\nInformacion basica:");
        lenguajeC.mostrarInformacion();

        System.out.println("\nInformacion con año:");
        lenguajeC.mostrarInformacion(true);

        System.out.println("\nInformacion completa:");
        lenguajeC.mostrarInformacion(
                "Informacion adicional proporcionada durante la ejecucion"
        );

        entrada.close();
    }

    // Solicita texto y evita que el usuario deje el campo vacio.
    private static String leerTexto(String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println(
                    "Error: el dato no puede estar vacio. Intenta otra vez."
            );
        }
    }

    // Solicita un entero positivo y controla los errores de conversion.
    private static int leerEnteroPositivo(String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = entrada.nextLine().trim();

            try {
                int numero = Integer.parseInt(texto);

                if (numero > 0) {
                    return numero;
                }

                System.out.println(
                        "Error: debes ingresar un numero entero positivo."
                );

            } catch (NumberFormatException error) {
                System.out.println(
                        "Error: escribe un numero entero valido. "
                                + "No se permiten letras ni decimales."
                );
            }
        }
    }
}