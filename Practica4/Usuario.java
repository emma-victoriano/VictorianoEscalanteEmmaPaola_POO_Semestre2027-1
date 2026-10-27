/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Esta clase es la hija de Persona, hereda sus datos básicos y le agrega
    cosas específicas de un usuario como los libros que debe o su teléfono
*/

public class Usuario extends Persona {

    // Declaracion de atributos ---------------------------------------------------------------

    private int librosPrestados;
    private String telefonoCelular;
    private boolean activo;

    // Declaracion de constructores -------------------------------------------------

    public Usuario() {
        super();
        this.librosPrestados = 0;
        this.telefonoCelular = "";
        this.activo = true;
    }

    public Usuario(int id, String nombre, String correo, boolean activo) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.librosPrestados = 0;
        this.telefonoCelular = "66-66-66-66-66";
        this.activo = activo;
    }

    // Declaracion de métodos -----------------------------------------------------------------

    /*
    -----------------------------------
    solicitarPrestamo
        Verifica que la cuenta del usuario esté activa, si sí lo está
        le suma un libro a su contador personal
    */
    public void solicitarPrestamo() {
        if (this.activo) {
            this.librosPrestados++;
        }
    }

    /*
    -----------------------------------
    devolverLibro
        Revisa que el usuario tenga al menos un libro prestado, si es
        mayor a cero le resta uno a su cuenta para que no queden números negativos
    */
    public void devolverLibro() {
        if (this.librosPrestados > 0) {
            this.librosPrestados--;
        }
    }

    /*
    -----------------------------------
    mostrarInformacion
        Esta es la versión obligatoria que nos pidió la clase padre,
        imprime los datos heredados y los nuevos en forma de lista
    */
    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Correo: " + this.correo);
        System.out.println("Estado: " + (this.activo ? "Activo" : "Inactivo"));
        System.out.println("Teléfono Celular: " + this.telefonoCelular);
        System.out.println("Libros Prestados: " + this.librosPrestados);
    }

    // Declaracion de métodos especiales ------------------------------------------------------

    // Setters

    /*
    setLibrosPrestados -----------------------------------

        Guarda la cantidad de libros pero verifica que no te pasen un
        número negativo, si lo hacen lo deja en cero y avisa del error
    */
    public void setLibrosPrestados(int librosPrestados) {
        if (librosPrestados >= 0) {
            this.librosPrestados = librosPrestados;
        } else {
            System.out.println("No puedes tener menos de cero libros prestados, se guardará como 0");
            this.librosPrestados = 0;
        }
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Getters
    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public boolean isActivo() {
        return activo;
    }
}