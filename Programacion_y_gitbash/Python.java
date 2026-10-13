public class Python extends Lenguaje {

    public Python(String nombre, int anioCreacion,
                  String paradigma, String caracteristica) {

        super(nombre, anioCreacion, paradigma, caracteristica);
    }

    public void mostrarCaracteristica() {
        System.out.println(
                "Característica: " + getCaracteristica()
        );
    }
}