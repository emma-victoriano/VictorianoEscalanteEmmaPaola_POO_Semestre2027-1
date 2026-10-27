/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Esta clase maneja los préstamos de la biblioteca, registra qué usuario
    se lleva qué libro, guarda las fechas de préstamo y devolución, y se
    encarga de actualizar los datos de ambos cuando el libro se entrega
    o se regresa
*/

public class Prestamo {

    // Declaracion de atributos ---------------------------------------------------------------

    private Usuario usuario;
    private Libro libro;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean activo;

    // Declaracion de constructores -------------------------------------------------

    public Prestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = "Pendiente";
        this.fechaDevolucion = "Pendiente";
        this.activo = false;
    }

    // Declaracion de métodos -----------------------------------------------------------------

    /*
    -----------------------------------
    iniciarPrestamo
        Verifica si el libro está libre. Si lo está, le avisa al libro que
        fue prestado, le suma un libro al usuario y activa el préstamo
        guardando la fecha actual.
    */
    public void iniciarPrestamo() {
        if (libro.estaDisponible()) {
            libro.prestar();
            usuario.solicitarPrestamo();
            this.activo = true;
            this.fechaPrestamo = "26-10-2026";
            System.out.println("Préstamo iniciado.");
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    /*
    -----------------------------------
    finalizarPrestamo
        Comprueba si el préstamo está en curso. Si es así, le avisa al libro
        que ya regresó, le resta el libro al usuario y cierra el préstamo.
    */
    public void finalizarPrestamo() {
        if (this.activo) {
            libro.devolver();
            usuario.devolverLibro();
            this.activo = false;
            this.fechaDevolucion = "30-10-2026";
            System.out.println("Préstamo finalizado.");
        }
    }

    public boolean estaActivo() {
        return activo;
    }

    // Declaracion de métodos especiales  ------------------------------------------------------

    // Setters
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Getters
    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
}