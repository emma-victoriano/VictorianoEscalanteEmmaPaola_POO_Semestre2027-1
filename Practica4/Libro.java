/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Esta clase representa los libros físicos de la biblioteca, aquí guardamos
    toda su información básica y controlamos si están disponibles para prestarse
    o si alguien ya se los llevó
*/
public class Libro implements Prestable {

    // Declaracion de atributos ---------------------------------------------------------------

    private String isbn;
    private String titulo;
    private String autor;
    private int publicacion;
    private boolean disponible;

    // Declaracion de constructores -------------------------------------------------

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, int publicacion, boolean disponible) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.disponible = disponible;
    }

    // Declaracion de métodos -----------------------------------------------------------------

    /*
    -----------------------------------
    prestar
        Es obligatorio por la interfaz Prestable, cambia el estado del libro
        a falso para indicar que ya no está disponible porque alguien se lo llevó
    */
    @Override
    public void prestar() {
        this.disponible = false;
    }

    /*
    -----------------------------------
    devolver
        Es obligatorio por la interfaz Prestable, vuelve a cambiar el estado
        a verdadero para que otro usuario pueda pedir este libro
    */
    @Override
    public void devolver() {
        this.disponible = true;
    }

    /*
    -----------------------------------
    mostrarInformacion
        Imprime todos los datos del libro de forma acomodada y revisa
        su booleano para mostrar si está disponible o no
    */
    public void mostrarInformacion() {
        System.out.println("--- Datos del Libro ---");
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Año de publicación: " + this.publicacion);

        if (this.disponible) {
            System.out.println("Estado: Disponible ");
        } else {
            System.out.println("Estado: Aqui no ta");
        }
    }

    // Declaracion de métodos especiales ------------------------------------------------------

    // Getters

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    // Setters

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    /*
    -----------------------------------
    setPublicacion
        Guarda el año de publicación pero revisa que no sea un número
        negativo, si lo es avisa del error y lo deja en cero
    */
    public void setPublicacion(int publicacion) {
        if (publicacion >= 0) {
            this.publicacion = publicacion;
        } else {
            System.out.println("El año no puede ser negativo, se guardará como 0");
            this.publicacion = 0;
        }
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}