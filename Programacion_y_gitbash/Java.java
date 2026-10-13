public class Java extends Lenguaje {

    public Java(String nombre, int anioCreacion,
                String paradigma, String caracteristica) {

        super(nombre, anioCreacion, paradigma, caracteristica);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL LENGUAJE ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Año de creación: " + getAnioCreacion());
        System.out.println("Paradigma: " + getParadigma());
        System.out.println("Característica: " + getCaracteristica());
    }
}