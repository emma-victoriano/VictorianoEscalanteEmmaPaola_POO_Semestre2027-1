import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;

public class Programa2 {

    //Método para obtener un número entero y para validar lo que ingrese el usuario
    //Se va a repetir mientras la entrada no sea valida
    public static int obtenerNumero(Scanner entrada, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            //Se verifica la entrada del usuario
            if (entrada.hasNextInt()) {
                return entrada.nextInt();
            }
            //Si no es entero, muestra el mensajey limpia la entrada
            System.out.println("Entrada no válida. Debes ingresar un número entero.");
            entrada.next();
        }
    }

    //Método para realizar operaciones matemáticas con 2 num enteros
    public static void realizarOperaciones(int numero1, int numero2) {

        System.out.println("\n===== OPERACIONES MATEMÁTICAS =====");

        System.out.println("Suma: " + (numero1 + numero2));
        System.out.println("Resta: " + (numero1 - numero2));
        System.out.println("Multiplicación: " + (numero1 * numero2));
        //División con validación para evitar división entre cero
        if (numero2 != 0) {
            System.out.println("División: " + ((double) numero1 / numero2));
        } else {
            System.out.println("No se puede realizar la división entre cero.");
        }

        System.out.println("Valor absoluto del primer número: "
                + Math.abs(numero1));

        System.out.println("Potencia del primer número al cuadrado: "
                + Math.pow(numero1, 2));

        System.out.println("Raíz cuadrada del primer número: "
                + Math.sqrt(Math.abs(numero1)));
    }

    //Método para mostrar la fecha actual usando date y calendar
    public static void mostrarFecha() {
        //Fecha actual con la clase date
        Date fechaActual = new Date();
        //Se usa calendar para obtener el día, mes y año de la fecha actual
        Calendar calendario = Calendar.getInstance();

        System.out.println("\n===== FECHA ACTUAL =====");

        System.out.println("Fecha utilizando Date: " + fechaActual);
        //Extrae dia, mes y año por separado
        System.out.println("Día: " + calendario.get(Calendar.DAY_OF_MONTH));
        System.out.println("Mes: " + (calendario.get(Calendar.MONTH) + 1));
        System.out.println("Año: " + calendario.get(Calendar.YEAR));
    }
    //Metodoprincipal del programa, donde se ejecutan los métodos anteriores y se solicita la entrada del usuario
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("===== PROGRAMA 2 =====");
        System.out.println("Autoboxing + Date + Calendar + Math\n");

        int numero1 = obtenerNumero(entrada, "Ingresa el primer número: ");
        int numero2 = obtenerNumero(entrada, "Ingresa el segundo número: ");

        //Autoboxing:
        //El valor primitivo int se convierte automáticamente en Integer.
        Integer numeroWrapper = numero1;

        System.out.println("\n===== AUTOBOXING =====");
        System.out.println("Número primitivo: " + numero1);
        System.out.println("Número convertido automáticamente a Integer: "
                + numeroWrapper);

        realizarOperaciones(numero1, numero2);

        mostrarFecha();

        entrada.close();
    }
}
