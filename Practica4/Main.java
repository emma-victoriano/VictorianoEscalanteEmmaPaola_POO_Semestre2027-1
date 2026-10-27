/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Este es el probador principal, aquí se instancia la clase Biblioteca
    para gestionar el registro de libros, de usuarios y la ejecución
    de los préstamos
*/

public class Main{

    // Declaracion de métodos -----------------------------------------------------------------

    public static void main(String[] args) {

        Biblioteca miBiblioteca;
        Libro libro1;
        Libro libro2;
        Libro libro3;
        Usuario usuario1;
        Usuario usuario2;
        Prestamo prestamo1;

        System.out.println("---------- ");

        miBiblioteca = new Biblioteca();

        System.out.println("\n--- Registro de Libros ---");
        libro1 = new Libro("111", "La casa de los espíritus", "Isabel Allende", 1982, true);
        libro2 = new Libro("222", "Eva Luna", "Isabel Allende", 1987, true);
        libro3 = new Libro("333", "De amor y de sombra", "Isabel Allende", 1984, true);

        miBiblioteca.agregarLibro(libro1);
        miBiblioteca.agregarLibro(libro2);
        miBiblioteca.agregarLibro(libro3);

        miBiblioteca.mostrarCatalogo();

        System.out.println("\n--- Registro y Lista de Usuarios ---");
        usuario1 = new Usuario(1, "Gabriel García Márquez", "gabo@unam.mx", true);
        usuario2 = new Usuario(2, "Julio Cortázar", "julio@unam.mx", true);

        miBiblioteca.registrarUsuario(usuario1);
        miBiblioteca.registrarUsuario(usuario2);

        miBiblioteca.mostrarUsuarios();

        System.out.println("\n--- Solicitud de Préstamo ---");

        miBiblioteca.realizarPrestamo(usuario1, libro2);
        miBiblioteca.mostrarPrestamosActivos();

        System.out.println("\n--- Devolución de Préstamo ---");
        prestamo1 = new Prestamo(usuario1, libro2);
        miBiblioteca.devolverLibro(prestamo1);

        System.out.println("\n--- Probando Búsquedas ---");
        System.out.println("Buscando por puro isbn: " + miBiblioteca.buscarLibro("222").getTitulo());
        System.out.println("Buscando por isbn y titulo: " + miBiblioteca.buscarLibro("333", "De amor y de sombra").getTitulo());
        System.out.println("Buscando al usuario 1: " + miBiblioteca.buscarUsuario(1).getNombre());

        System.out.println("\n--- Eliminando Libro ---");
        miBiblioteca.eliminarLibro("111");
        miBiblioteca.mostrarCatalogo();

    }
}