public class Lenguaje {

    private String nombre;
    private int anioCreacion;
    private String paradigma;
    private String caracteristica;

    public Lenguaje() {
    }

    public Lenguaje(String nombre, int anioCreacion,
                    String paradigma, String caracteristica) {
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
        this.paradigma = paradigma;
        this.caracteristica = caracteristica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public String getParadigma() {
        return paradigma;
    }

    public void setParadigma(String paradigma) {
        this.paradigma = paradigma;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    // Sobrecarga 1: muestra solamente el nombre.
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
    }

    // Sobrecarga 2: muestra el nombre y el año.
    public void mostrarInformacion(boolean incluirAnio) {
        System.out.println("Nombre: " + nombre);

        if (incluirAnio) {
            System.out.println("Año de creación: " + anioCreacion);
        }
    }

    // Sobrecarga 3: muestra toda la información.
    public void mostrarInformacion(String detalleAdicional) {
        System.out.println("Nombre: " + nombre);
        System.out.println("Año de creación: " + anioCreacion);
        System.out.println("Paradigma: " + paradigma);
        System.out.println("Característica: " + caracteristica);
        System.out.println("Detalle adicional: " + detalleAdicional);
    }
}