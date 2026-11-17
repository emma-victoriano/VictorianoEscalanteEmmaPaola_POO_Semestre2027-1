/*
 * Perez Galindo Claudia
 * Carlos Zepeda Calalpa
 * Cuevas Angeles
 * Emma Paola Victoriano Escalante
 *
 * Este programa funciona como un sistema interactivo para un puesto de chimichangas
 * Permite al usuario elegir opciones mediante un menu por consola
 * Incluye validaciones y manejo de multiples excepciones en tiempo de ejecucion
 * tales como errores de archivos faltantes, entradas invalidas de teclado
 * conversiones erroneas de texto a numero, divisiones entre cero y objetos nulos
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PuestoChimichangasCookie {
    public static void main(String[] args) {
        // Inicializamos el objeto Scanner para permitir la interacción con el usuario mediante la consola
        Scanner sc = new Scanner(System.in);

        System.out.println("--- PUESTO DE CHIMICHANGAS ---");
        System.out.println("1 Leer menu de archivos");
        System.out.println("2 Pedir chimichangas y calcular");
        System.out.print("Elige una opcion ");

        // Iniciamos el bloque try para atrapar posibles errores o excepciones durante la ejecución
        try {
            // Leemos la opción numérica ingresada por el usuario desde el teclado
            int opcion = sc.nextInt();

            // Evaluamos si el usuario eligió la opción uno para consultar archivos
            if (opcion == 1) {
                // Creamos un objeto File apuntando a un archivo que no existe para provocar una excepción
                File archivo = new File("menu_inexistente.txt");
                if (!archivo.exists()) {
                    // Lanzamos explícitamente la excepción si el archivo no es encontrado
                    throw new FileNotFoundException("El archivo del menu no fue encontrado");
                }
            } else if (opcion == 2) {
                // Limpiamos el buffer del teclado después de leer un entero
                sc.nextLine();

                // Solicitamos una cantidad en formato de texto para probar la conversión
                System.out.print("Ingresa la cantidad de chimichangas en texto ");
                String entrada = sc.nextLine();
                // Intentamos convertir la cadena de texto a un número entero
                int cantidad = Integer.parseInt(entrada);

                // Solicitamos el número de personas para realizar un cálculo matemático
                System.out.print("Ingresa el numero de personas para dividir la cuenta ");
                int personas = sc.nextInt();
                // Realizamos una división que provocará un error aritmético si se ingresa cero
                int division = 100 / personas;

                // Declaramos una referencia a objeto con valor nulo para provocar un fallo al invocar métodos
                String clienteFrecuente = null;
                System.out.println("Buscando cliente " + clienteFrecuente.length());

            }

            // Capturamos cada excepción de forma específica y mostramos el tipo de error correspondiente
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (java.util.InputMismatchException e) {
            System.out.println("InputMismatchException");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }
    }
}