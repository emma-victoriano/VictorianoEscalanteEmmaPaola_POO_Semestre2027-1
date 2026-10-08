package Practica4;

/*Realizado por:
    - Pérez Galindo Claudia
    - 

    Falta ver que no acepte valores negativos en los setters
-----------------------------------
Funcionamiento general

    Este es el molde inicial para armar las demás clases, contiene las características mas
    básicas que heredarán las clases hijas (Usuario y Bibliotecario)

*/

public abstract class Persona {

    // Declaracion de atributos ---------------------------------------------------------------

    protected int id;
    protected String nombre;
    protected String correo;

    

    // Declaracion de métodos -----------------------------------------------------------------
    public abstract void mostrarInformacion();

    // Declaracion de métodos especiales  ------------------------------------------------------

    // Setters

    public void setId(int id) {

        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

}