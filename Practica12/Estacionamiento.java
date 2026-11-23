// Cuevas Angeles Daniela
// Pérez Galindo Claudia Meztli
// Victoriano Escalante Emma Paola
// Zepeda Calalpa Carlos

// Clase encargada de administrar los espacios del estacionamiento.
public class Estacionamiento {

    // Variable que almacena la cantidad de espacios disponibles.
    private int espaciosDisponibles;

    // Constructor que recibe la capacidad inicial del estacionamiento.
    public Estacionamiento(int capacidad) {
        espaciosDisponibles = capacidad;
    }

    // Método sincronizado que permite ingresar a los automóviles.
    public synchronized void ingresar(String nombre) {

        // Comprueba si ya no existen espacios disponibles.
        while (espaciosDisponibles == 0) {

            // Informa que el automóvil debe esperar.
            System.out.println(nombre +
                    " espera, el estacionamiento esta lleno");

            try {

                // El hilo queda en espera hasta recibir una notificación.
                wait();

            } catch (InterruptedException e) {

                // Muestra un mensaje si se interrumpe la espera.
                System.out.println("Ingreso interrumpido");

                // Finaliza el método si ocurre una interrupción.
                return;
            }
        }

        // Disminuye la cantidad de espacios disponibles al ingresar.
        espaciosDisponibles--;

        // Muestra el mensaje de ingreso del automóvil.
        System.out.println(nombre + " ingreso al estacionamiento");

        // Muestra cuántos espacios quedan libres.
        System.out.println("Espacios disponibles: "
                + espaciosDisponibles);
    }

    // Método sincronizado que permite salir a los automóviles.
    public synchronized void salir(String nombre) {

        // Aumenta la cantidad de espacios disponibles al salir.
        espaciosDisponibles++;
        // Muestra el mensaje de salida del automóvil.
        System.out.println(nombre + " salio del estacionamiento");
        // Muestra la cantidad actual de espacios disponibles.
        System.out.println("Espacios disponibles: "
                + espaciosDisponibles);
        // Notifica a todos los hilos que se encuentran esperando.
        notifyAll();
    }
}