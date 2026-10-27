/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Esta clase es para los bibliotecarios, heredan los datos básicos de Persona
    y tienen sus propios métodos para gestionar el sistema
*/

public class Bibliotecario extends Persona {

    // Declaracion de atributos ---------------------------------------------------------------

    private String turno;
    private double salario;

    // Declaracion de constructores -------------------------------------------------

    public Bibliotecario() {
        super();
        this.turno = "";
        this.salario = 0.0;
    }

    public Bibliotecario(int id, String nombre, String correo, String turno, double salario) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.turno = turno;
        this.salario = salario;
    }

    // Declaracion de métodos -----------------------------------------------------------------

    /*
    -----------------------------------
    autorizarPrestamo
        Imprime un mensaje simulando que este bibliotecario dio permiso para un préstamo
    */
    public void autorizarPrestamo() {
        System.out.println("El bibliotecario " + this.nombre + " autorizó el préstamo");
    }

    /*
    -----------------------------------
    registrarLibro
        Simula la acción de guardar un libro en el sistema
    */
    public void registrarLibro() {
        System.out.println("El bibliotecario " + this.nombre + " registró un nuevo libro");
    }

    /*
    -----------------------------------
    eliminarLibro
        Simula la acción de borrar un libro del sistema
    */
    public void eliminarLibro() {
        System.out.println("El bibliotecario " + this.nombre + " eliminó un libro del sistema");
    }

    /*
    -----------------------------------
    mostrarInformacion
        Muestra todos los datos de la persona y le agrega el turno y el pago
    */
    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Correo: " + this.correo);
        System.out.println("Turno: " + this.turno);
        System.out.println("Salario: $" + this.salario);
    }

    // Declaracion de métodos especiales ------------------------------------------------------

    // Getters

    public String getTurno() {
        return turno;
    }

    public double getSalario() {
        return salario;
    }

    // Setters

    public void setTurno(String turno) {
        this.turno = turno;
    }

    /*
    -----------------------------------
    setSalario
        Revisa que el pago no sea un número negativo, si lo es avisa del error y lo deja en cero
    */
    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        } else {
            System.out.println("El salario no puede ser negativo, se guardará como 0");
            this.salario = 0.0;
        }
    }
}