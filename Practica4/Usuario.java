package Practica4;

/*Realizado por:
    - Pérez Galindo Claudia
    - 

 lo mismo, ver que no se pueda romper pipipipi
-----------------------------------
Funcionamiento general

    

*/

public class Usuario extends Persona {

    // Declaracion de atributos ---------------------------------------------------------------

    private int librosPrestados;
    private String telefonoCelular;
    private boolean activo;


    // Métodos especiales -------------------------------------------------

    // Setters

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
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


    // Declaracion de constructores -------------------------------------------------


    public Usuario() {
        super();
        this.librosPrestados = 0;
        this.telefonoCelular = "";
        this.activo = true;
    }

    public Usuario(int id, String nombre, String correo, boolean activo) {
        super();
        this.librosPrestados = 0;
        this.telefonoCelular = "55-55-55-55-55";
        this.activo = activo;
    }



    // Declaracion de métodos -----------------------------------------------------------------

    public void solicitarPrestamo() {
        if (this.activo) {
            this.librosPrestados++;
        }
    }

    public void devolverLibro() {
        if (this.librosPrestados > 0) {
            this.librosPrestados--;
        }
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("ID: " + this.id);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Correo: " + this.correo);
        // Para poder mostrar el estado del usuario, se puede usar un operador ternario para mostrar "Activo" o "Inactivo" según el valor del atributo activo.
        System.out.println("Estado: " + (this.activo ? "Activo" : "Inactivo"));
        System.out.println("Teléfono Celular: " + this.telefonoCelular);
        System.out.println("Libros Prestados: " + this.librosPrestados);
    }

}