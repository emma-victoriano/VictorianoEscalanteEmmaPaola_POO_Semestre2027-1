package Ejercicio2;

import java.util.Scanner;

public class mainComputadora{

    public static void main(String[]args){

        //-------------Inicializacion de Scanner y Arreglo----------------
        // Preparamos el Scanner para recibir los datos por el teclado
        Scanner entrada=new Scanner(System.in);

        // Se crea el arreglo de solo 2 computadoras como indico el profesor
        Computadora[]computadoras=new Computadora[2];

        // Variable para recorrer el arreglo desde la posicion 0
        int i=0;

        //-------------Llenado de datos con ciclo do-while----------------
        // Usamos do-while para pedir los datos al menos una vez y repetir hasta llenar los 2 lugares
        do{
            System.out.println("\nComputadora "+(i+1));

            //-------------Validacion de Memoria RAM----------------
            // Validamos que el dato ingresado sea estrictamente un entero
            System.out.print("Memoria RAM (GB): ");
            while(!entrada.hasNextInt()){
                System.out.println("Debe ingresar un numero entero.");
                entrada.next(); // Limpia la entrada incorrecta del buffer
                System.out.print("Memoria RAM (GB): ");
            }
            int memoriaRam=entrada.nextInt();

            //-------------Validacion de Almacenamiento----------------
            // Validamos que el almacenamiento tambien sea un entero
            System.out.print("Almacenamiento (GB): ");
            while(!entrada.hasNextInt()){
                System.out.println("Debe ingresar un numero entero.");
                entrada.next();
                System.out.print("Almacenamiento (GB): ");
            }
            int almacenamiento=entrada.nextInt();

            //-------------Validacion de Fuente de Energia----------------
            // Validamos la potencia de la fuente como entero
            System.out.print("Fuente de energia (Watts): ");
            while(!entrada.hasNextInt()){
                System.out.println("Debe ingresar un numero entero.");
                entrada.next();
                System.out.print("Fuente de energia (Watts): ");
            }
            int fuenteEnergia=entrada.nextInt();

            // Limpiamos el buffer para que no se salte la lectura del texto
            entrada.nextLine();

            // Pedimos el nombre del procesador 
            System.out.print("CPU: ");
            String cpu=entrada.nextLine();

            //-------------Validacion de GPU con if-else----------------
            // Preguntamos para que el usuario pueda escribir mayuscula o minuscula libremente :)
            System.out.print("¿Cuenta con GPU dedicada? (S/s o N/n): ");
            String respuestaGpu=entrada.nextLine();
            boolean gpu;

            // Condicional if-else para revisar si ingreso S o s
            if(respuestaGpu.equals("S")||respuestaGpu.equals("s")){
                gpu=true; // Si es S o s guardamos true
            }else{
                gpu=false; // Si es cualquier otra letra guardamos false
            }

            //-------------Creacion del Objeto----------------
            // Creamos el objeto en la posicion correspondiente usando el constructor completo
            computadoras[i]=new Computadora(memoriaRam,almacenamiento,fuenteEnergia,cpu,gpu);

            // Incrementamos el contador para pasar a la siguiente computadora
            i++;

        // La condicion se repite mientras i sea menor al tamaño del arreglo (2)
        }while(i<computadoras.length);

        //-------------Impresion con ciclo for----------------
        // Imprimimos la lista recorriendo todo el arreglo con for
        System.out.println("\n============= LISTA DE COMPUTADORAS =============");

        for(i=0;i<computadoras.length;i++){

            System.out.println("\nComputadora "+(i+1));
            // Mostramos los datos usando los getters que creamos
            System.out.println("CPU: "+computadoras[i].getCpu());
            System.out.println("Memoria RAM: "+computadoras[i].getMemoriaRam()+" GB");
            System.out.println("Almacenamiento: "+computadoras[i].getAlmacenamiento()+" GB");
            System.out.println("Fuente de energia: "+computadoras[i].getFuenteEnergia()+" W");

            // Condicional para mostrar en texto si tiene tarjeta grafica o no
            if(computadoras[i].getGpu()){
                System.out.println("GPU: Si cuenta con GPU dedicada");
            }else{
                System.out.println("GPU: No cuenta con GPU dedicada");
            }
        }

        // Cerramos el Scanner al terminar el programa
        entrada.close();
    }
}
