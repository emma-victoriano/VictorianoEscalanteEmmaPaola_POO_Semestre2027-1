// Cuevas Angeles Daniela
// Perez Galindo Claudia Meztli
// Victoriano Escalante Emma Paola
// Zepeda Calalpa Carlos

import java.util.Random;
import java.util.Scanner;

// Cada caballo hereda de Thread para correr en su propio hilo de manera independiente
class Caballo extends Thread {

    private static final int META = 10;
    private static final int PAUSA_MINIMA = 200;
    private static final int PAUSA_EXTRA = 400;
    private static final Object CANDADO = new Object();
    private static String ganador = null;

    private String nombreCaballo;
    private int avance;
    private Random azar;

    public Caballo(String nombreCaballo) {
        this.nombreCaballo = nombreCaballo;
        this.avance = 0;
        this.azar = new Random();
    }

    public String getNombreCaballo() {
        return nombreCaballo;
    }

    public static String getGanador() {
        synchronized (CANDADO) {
            return ganador;
        }
    }

    @Override
    public void run() {
        int pausa;

        try {
            while (avance < META) {
                pausa = PAUSA_MINIMA + azar.nextInt(PAUSA_EXTRA);
                Thread.sleep(pausa);
                avance++;
                System.out.println("  >> " + nombreCaballo + " galopa al metro " + avance + " de " + META);

                synchronized (CANDADO) {
                    if (avance >= META && ganador == null) {
                        ganador = nombreCaballo;
                        System.out.println("  *** ¡" + nombreCaballo + " cruza la meta en primer lugar! ***");
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("  !! " + nombreCaballo + " tuvo que detenerse");
        }
    }
}

public class CarreraDeCaballos {

    private static int leerEntero(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            teclado.next();
            System.out.println("Por favor escribe un numero entero valido:");
        }
        return teclado.nextInt();
    }

    private static void mostrarBienvenida(Caballo[] caballos) {
        int i;

        System.out.println("====================================================");
        System.out.println("   BIENVENIDO AL HIPODROMO \"HERMANOS GALEANA\"  ");
        System.out.println("====================================================");
        System.out.println("Conoce a nuestros corredores de hoy:");
        System.out.println("----------------------------------------------------");
        for (i = 0; i < caballos.length; i++) {
            System.out.println("  " + (i + 1) + ") " + caballos[i].getNombreCaballo());
        }
        System.out.println("----------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Caballo[] caballos = {
                new Caballo("Vicente"),
                new Caballo("Spirit"),
                new Caballo("Fobos"),
                new Caballo("Ricardo")
        };
        String nombreJugador;
        int saldo = 500;
        int eleccion;
        int apuesta;
        int pago;
        int i;
        String ganadorCarrera;

        mostrarBienvenida(caballos);

        System.out.println(" ¿Cual es tu nombre?");
        nombreJugador = teclado.nextLine();

        System.out.println("¡Que gusto tenerte aqui, " + nombreJugador + "! Tu saldo inicial es de $" + saldo + ".");
        System.out.println("¿A cual caballo quieres apostarle? (1 a " + caballos.length + "):");
        eleccion = leerEntero(teclado);
        while (eleccion < 1 || eleccion > caballos.length) {
            System.out.println("Ese numero no corresponde a ningun caballo, elige del 1 al " + caballos.length + ":");
            eleccion = leerEntero(teclado);
        }

        System.out.println("¿Cuanto dinero deseas apostar a " + caballos[eleccion - 1].getNombreCaballo() + "? (Saldo disponible: $" + saldo + "):");
        apuesta = leerEntero(teclado);
        while (apuesta <= 0 || apuesta > saldo) {
            System.out.println("Monto no valido, recuerda que tienes $" + saldo + " disponibles. Escribe otro monto:");
            apuesta = leerEntero(teclado);
        }

        saldo -= apuesta;
        System.out.println("¡Apuesta registrada! Apostaste $" + apuesta + " por " + caballos[eleccion - 1].getNombreCaballo() + ".");
        System.out.println("¡Arrancan los caballos!");
        System.out.println("----------------------------------------------------");

        for (i = 0; i < caballos.length; i++) {
            caballos[i].start();
        }

        try {
            for (i = 0; i < caballos.length; i++) {
                caballos[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("La espera de la carrera fue interrumpida.");
        }

        ganadorCarrera = Caballo.getGanador();
        System.out.println("----------------------------------------------------");
        System.out.println("¡Gran ganador de la carrera: " + ganadorCarrera + "!");

        if (caballos[eleccion - 1].getNombreCaballo().equals(ganadorCarrera)) {
            pago = apuesta * 2;
            saldo += pago;
            System.out.println("¡Increible, " + nombreJugador + "! Tu caballo gano y cobras $" + pago + ".");
        } else {
            System.out.println("¡Lastima, " + nombreJugador + "! Esta vez no se dio, pero la proxima sera.");
        }

        System.out.println("Saldo final de " + nombreJugador + ": $" + saldo);
        System.out.println("====================================================");

        teclado.close();
    }
}