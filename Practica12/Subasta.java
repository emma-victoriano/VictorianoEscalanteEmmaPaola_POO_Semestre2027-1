// Cuevas Angeles Daniela
// Pérez Galindo Claudia Meztli
// Victoriano Escalante Emma Paola
// Zepeda Calalpa Carlos

import java.util.Random;
import java.util.Scanner;

// Cada postor automático de la subasta es un objeto que se ejecuta en su propio hilo.
// Se usa la interfaz Runnable para poder crear los hilos con Thread.
public class Subasta implements Runnable {

    // Constantes, son valores que no cambian durante el programa
    private static final String ARTICULO = "una guitarra firmada por una estrella de rock"; // lo que se subasta
    private static final int PRECIO_INICIAL = 100; // precio con el que empieza el artículo
    private static final int INCREMENTO = 50;      // cantidad que sube cada oferta automática
    private static final int RONDAS = 5;           // veces que intenta ofertar cada postor automático
    private static final int ESPERA_MINIMA = 1500; // tiempo mínimo entre ofertas en milisegundos
    private static final int ESPERA_EXTRA = 2000;  // tiempo extra al azar en milisegundos
    private static final int TURNOS_JUGADOR = 5;   // turnos que tiene la persona que juega

    // Datos compartidos, todos los postores ven y cambian estos valores
    private static int ofertaMasAlta = PRECIO_INICIAL;
    private static String ganadorActual = "Nadie";
    private static boolean subastaTerminada = false;

    // Datos de los postores automáticos, se guardan aquí para poder revisar si aún pueden ofertar
    private static String[] nombresAutomaticos = {"Ana", "Luis", "Marta"};
    private static int[] presupuestosAutomaticos = {400, 300, 500};

    // Datos de la persona que juega, se llenan al inicio del programa
    private static String nombreJugador = "";
    private static int presupuestoJugador = 0;

    // Datos propios de cada postor automático
    private String nombrePostor;
    private int presupuesto;
    private Random generadorAzar = new Random();

    // Constructor, guarda el nombre y el dinero máximo que puede ofrecer el postor
    public Subasta(String nombrePostor, int presupuesto) {
        this.nombrePostor = nombrePostor;
        this.presupuesto = presupuesto;
    }

    // Este método es lo que hace cada hilo cuando se inicia con start
    @Override
    public void run() {
        int ronda;
        int espera;

        try {
            // El postor deja de intentar si la subasta ya se cerró
            for (ronda = 0; ronda < RONDAS && !estaTerminada(); ronda++) {
                // El postor espera un tiempo al azar antes de ofertar
                espera = ESPERA_MINIMA + generadorAzar.nextInt(ESPERA_EXTRA);
                Thread.sleep(espera);
                ofertar(nombrePostor, presupuesto);
            }
        } catch (InterruptedException e) {
            System.out.println("¡Alto! " + nombrePostor + " fue interrumpido y sale de la subasta");
        }
        System.out.println("*** " + nombrePostor + " no va a ofertar más ***");
    }

    // Método sincronizado, solo un postor a la vez puede revisar y cambiar la oferta más alta.
    // Es static porque los datos compartidos también son static.
    private static synchronized void ofertar(String nombre, int dineroMaximo) {
        int nuevaOferta;

        // Si la subasta ya se cerró, no se hace nada
        if (subastaTerminada) {
            return;
        }

        // La nueva oferta es la más alta actual más el incremento
        nuevaOferta = ofertaMasAlta + INCREMENTO;

        if (nombre.equals(ganadorActual)) {
            // Si ya va ganando, no tiene sentido que se supere a sí mismo
            System.out.println(nombre + " va ganando :P");
        } else if (nuevaOferta <= dineroMaximo) {
            // Si le alcanza el dinero, hace la oferta y pasa a ser el ganador actual
            ofertaMasAlta = nuevaOferta;
            ganadorActual = nombre;
            System.out.println("¡¡¡" + nombre + " sube la apuesta a $" + nuevaOferta
                    + " por " + ARTICULO + " y la sala se vuelve loca!!!");
        } else {
            // Si no le alcanza, ya no puede seguir ofertando
            System.out.println("¡Oh no! " + nombre + " ya no puede ofertar, su máximo es $" + dineroMaximo);
        }

        // Después de cada intento se revisa si todavía alguien puede ofertar
        if (nadieMasPuedeOfertar()) {
            terminarSubasta();
        }
    }

    // Método sincronizado para la oferta de la persona que juega.
    // Usa el mismo candado que ofertar, así nunca cambian la oferta al mismo tiempo.
    private static synchronized void ofertarJugador(String nombre, int monto, int dineroMaximo) {
        if (monto <= ofertaMasAlta) {
            // La oferta debe superar a la actual para ser válida
            System.out.println("Tu oferta de $" + monto + " no supera los $" + ofertaMasAlta + " y pierdes el turno");
        } else if (monto > dineroMaximo) {
            // No se puede ofrecer más dinero del que se tiene
            System.out.println("¡Cuidado! No tienes tanto dinero, tu máximo es $" + dineroMaximo);
        } else {
            // La oferta es válida, así que la persona pasa a ser el ganador actual
            ofertaMasAlta = monto;
            ganadorActual = nombre;
            System.out.println("¡¡¡" + nombre + " sube la apuesta a $" + monto
                    + " por " + ARTICULO + " y todos contienen el aliento!!!");
        }

        // Después de la oferta se revisa si todavía alguien puede ofertar
        if (nadieMasPuedeOfertar()) {
            terminarSubasta();
        }
    }

    // Revisa si algún postor automático que no va ganando todavía le alcanza para subir la oferta
    private static synchronized boolean automaticosPuedenOfertar() {
        int indice;
        boolean alguienPuede = false;

        for (indice = 0; indice < nombresAutomaticos.length; indice++) {
            if (!nombresAutomaticos[indice].equals(ganadorActual)
                    && ofertaMasAlta + INCREMENTO <= presupuestosAutomaticos[indice]) {
                alguienPuede = true;
            }
        }
        return alguienPuede;
    }

    // Revisa si la persona que juega todavía tiene dinero para superar la oferta más alta
    private static synchronized boolean jugadorPuedeOfertar() {
        return !nombreJugador.equals(ganadorActual) && ofertaMasAlta < presupuestoJugador;
    }

    // Es verdadero cuando ni los automáticos ni la persona pueden ofertar
    private static synchronized boolean nadieMasPuedeOfertar() {
        return !automaticosPuedenOfertar() && !jugadorPuedeOfertar();
    }

    // Cierra la subasta una sola vez y avisa a todos
    private static synchronized void terminarSubasta() {
        if (!subastaTerminada) {
            subastaTerminada = true;
            System.out.println("¡¡¡Ya nadie más puede ofertar, se cierra la subasta!!!");
        }
    }

    // Método sincronizado para consultar si la subasta ya se cerró
    private static synchronized boolean estaTerminada() {
        return subastaTerminada;
    }

    // Método sincronizado para consultar la oferta más alta sin leerla a la mitad de un cambio
    private static synchronized int consultarOfertaMasAlta() {
        return ofertaMasAlta;
    }

    // Lee un número entero del teclado y repite la pregunta si se escribe otra cosa
    private static int leerNumero(Scanner teclado) {
        while (!teclado.hasNextInt()) {
            // Se descarta lo escrito porque no es un número
            teclado.next();
            System.out.println("Eso no es un número, intenta de nuevo");
        }
        return teclado.nextInt();
    }

    public static void main(String[] args) {
        Thread[] postores = new Thread[nombresAutomaticos.length];
        Scanner teclado = new Scanner(System.in);
        int montoJugador;
        int indice;
        int turno;

        System.out.println("¡¡¡Bienvenido a la gran subasta!!!");
        System.out.println("Hoy se subasta " + ARTICULO);
        System.out.println("Escribe tu nombre");
        nombreJugador = teclado.nextLine();
        System.out.println("¿Cuánto dinero tienes para ofertar?");
        presupuestoJugador = leerNumero(teclado);

        System.out.println("¡¡¡Comienza la subasta!!! El precio inicial de " + ARTICULO
                + " es de $" + PRECIO_INICIAL);

        // Se crea y se inicia un hilo por cada postor automático
        for (indice = 0; indice < nombresAutomaticos.length; indice++) {
            postores[indice] = new Thread(new Subasta(nombresAutomaticos[indice], presupuestosAutomaticos[indice]));
            postores[indice].start();
        }

        // Mientras los hilos ofertan, la persona juega sus turnos desde el teclado.
        // Los turnos se acaban si se cierra la subasta.
        for (turno = 1; turno <= TURNOS_JUGADOR && !estaTerminada(); turno++) {
            System.out.println("Turno " + turno + " de " + TURNOS_JUGADOR + ". La oferta más alta por "
                    + ARTICULO + " es $" + consultarOfertaMasAlta() + ". Escribe tu oferta o 0 para pasar");
            montoJugador = leerNumero(teclado);

            if (estaTerminada()) {
                // La subasta se cerró mientras la persona escribía
                System.out.println("¡Tu oferta llegó tarde, la subasta ya se cerró!");
            } else if (montoJugador == 0) {
                System.out.println(nombreJugador + " decide esperar y observa a los rivales");
                // Si la persona pasa y los automáticos ya no pueden subir, se cierra la subasta
                if (!automaticosPuedenOfertar()) {
                    terminarSubasta();
                }
            } else {
                ofertarJugador(nombreJugador, montoJugador, presupuestoJugador);
            }
        }

        // Si la subasta se cerró antes de tiempo, se interrumpe a los hilos que sigan esperando
        if (estaTerminada()) {
            for (indice = 0; indice < postores.length; indice++) {
                postores[indice].interrupt();
            }
        }

        // join hace que main espere a que todos los hilos terminen
        try {
            for (indice = 0; indice < postores.length; indice++) {
                postores[indice].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida");
        }

        teclado.close();

        // Se anuncia al ganador
        System.out.println("¡¡¡VENDIDOOOOOOOOOOO!!! " + ARTICULO + " es para " + ganadorActual
                + " por $" + ofertaMasAlta);
    }
}