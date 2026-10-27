import java.util.ArrayList;

/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    Aquí se guardan las listas de todos los
    libros, usuarios y préstamos. También se encarga de buscar, agregar
    o eliminar elementos dentro de esas listas.
*/

public class Biblioteca {

    // Declaracion de atributos ---------------------------------------------------------------

    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Bibliotecario> empleados;
    private ArrayList<Prestamo> prestamos;

    // Declaracion de constructores -------------------------------------------------

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    // Declaracion de métodos -----------------------------------------------------------------

    // Gestión de Libros ----------------------------------------------------------------------

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("El libro se agregó con éxito al catálogo.");
    }

    public void eliminarLibro(String isbn) {
        Libro libroEncontrado;

        libroEncontrado = buscarLibro(isbn);

        if (libroEncontrado != null) {
            libros.remove(libroEncontrado);
            System.out.println("El libro fue eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún libro con ese ISBN.");
        }
    }

    /*
    -----------------------------------
    buscarLibro (por ISBN)
        Recorre la lista de libros uno por uno. Si encuentra un libro que
        tenga exactamente el mismo ISBN que le pasamos, nos devuelve ese libro.
        Si termina de revisar toda la lista y no está, devuelve nulo.
    */
    public Libro buscarLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    /*
    -----------------------------------
    buscarLibro (por Título y Autor)
        Hace exactamente lo mismo que el metodo de arriba, pero busca
        comparando el título y el autor al mismo tiempo. Sirve por si
        no nos sabemos el número de ISBN.
    */
    public Libro buscarLibro(String titulo, String autor) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.getAutor().equalsIgnoreCase(autor)) {
                return libro;
            }
        }
        return null;
    }

    public void mostrarCatalogo() {
        System.out.println("--- Catálogo de la Biblioteca ---");
        for (Libro libro : libros) {
            libro.mostrarInformacion();
            System.out.println("---------------------------");
        }
    }

    // Gestión de Usuarios --------------------------------------------------------------------

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado con éxito.");
    }

    /*
    -----------------------------------
    buscarUsuario
        Recorre toda la lista de usuarios registrados. Si el ID de alguno
        coincide con el que le pedimos buscar, nos regresa sus datos
    */
    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarUsuarios() {
        System.out.println("--- Lista de Usuarios ---");
        for (Usuario usuario : usuarios) {
            usuario.mostrarInformacion();
            System.out.println("---------------------------");
        }
    }

    // Gestión de Préstamos -------------------------------------------------------------------

    public void realizarPrestamo(Usuario usuario, Libro libro) {
        Prestamo nuevoPrestamo;

        nuevoPrestamo = new Prestamo(usuario, libro);
        nuevoPrestamo.iniciarPrestamo();
        prestamos.add(nuevoPrestamo);
    }

    public void devolverLibro(Prestamo prestamo) {
        prestamo.finalizarPrestamo();
    }

    /*
    -----------------------------------
    mostrarPrestamosActivos
        Revisa la lista de todos los préstamos que se han hecho.
        Si encuentra alguno que siga activo (que no han regresado el libro), imprime qué
        usuario lo tiene y qué libro se llevó
    */
    public void mostrarPrestamosActivos() {
        System.out.println("--- Préstamos Activos ---");
        for (Prestamo prestamo : prestamos) {
            if (prestamo.estaActivo()) {
                System.out.println("Usuario: " + prestamo.getUsuario().getNombre() +
                        " | Libro: " + prestamo.getLibro().getTitulo());
            }
        }
    }
}