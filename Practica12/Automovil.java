// Cuevas Angeles Daniela
// Pérez Galindo Claudia Meztli
// Victoriano Escalante Emma Paola
// Zepeda Calalpa Carlos

// La clase hereda de Thread para que cada automóvil sea un hilo.
public class Automovil extends Thread {
    // Referencia al estacionamiento que compartirán los automóviles.
    private Estacionamiento estacionamiento;
    // Variable que almacena el tiempo que permanecerá estacionado.
    private int tiempoEstancia;
    // Constructor que recibe el nombre, estacionamiento y tiempo de estancia.
    public Automovil(String nombre, Estacionamiento estacionamiento,
                     int tiempoEstancia) {
        // Asigna el nombre al hilo mediante el constructor de Thread.
        super(nombre);
        // Guarda la referencia al estacionamiento compartido.
        this.estacionamiento = estacionamiento;
        // Guarda el tiempo que permanecerá el automóvil.
        this.tiempoEstancia = tiempoEstancia;
    }

    // Método run que contiene las instrucciones que ejecutará cada hilo.
    @Override
    public void run() {
        // Muestra que el automóvil intenta ingresar.
        System.out.println(getName() + " intenta ingresar");
        // Solicita un espacio en el estacionamiento.
        estacionamiento.ingresar(getName());
        try {
            // Simula el tiempo que permanece estacionado el automóvil.
            Thread.sleep(tiempoEstancia);
        } catch (InterruptedException e) {
            // Muestra un mensaje si se interrumpe la estancia.
            System.out.println("Estancia interrumpida");
        }
        // Solicita salir del estacionamiento y libera el espacio.
        estacionamiento.salir(getName());
    }

    // Método principal donde comienza la ejecución del programa.
    public static void main(String[] args) {
        // Crea un estacionamiento con capacidad para tres automóviles.
        Estacionamiento estacionamiento = new Estacionamiento(3);
        // Crea el primer automóvil con una estancia de cinco segundos.
        Automovil auto1 = new Automovil(
                "Automovil 1", estacionamiento, 5000);
        // Crea el segundo automóvil con una estancia de siete segundos.
        Automovil auto2 = new Automovil(
                "Automovil 2", estacionamiento, 7000);
        // Crea el tercer automóvil con una estancia de cuatro segundos.
        Automovil auto3 = new Automovil(
                "Automovil 3", estacionamiento, 4000);
        // Crea el cuarto automóvil con una estancia de tres segundos.
        Automovil auto4 = new Automovil(
                "Automovil 4", estacionamiento, 3000);
        // Crea el quinto automóvil con una estancia de seis segundos.
        Automovil auto5 = new Automovil(
                "Automovil 5", estacionamiento, 6000);
        // Inicia el hilo correspondiente al primer automóvil.
        auto1.start();
        // Inicia el hilo correspondiente al segundo automóvil.
        auto2.start();
        // Inicia el hilo correspondiente al tercer automóvil.
        auto3.start();
        // Inicia el hilo correspondiente al cuarto automóvil.
        auto4.start();
        // Inicia el hilo correspondiente al quinto automóvil.
        auto5.start();
        // Indica que el programa ya inició el funcionamiento del estacionamiento.
        System.out.println("Estacionamiento en funcionamiento");
    }
}