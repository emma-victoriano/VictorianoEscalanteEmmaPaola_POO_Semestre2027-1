public class C extends Lenguaje {

    public C(String nombre, int anioCreacion, String paradigma, String caracteristica) {

        setNombre(nombre);
        setAnioCreacion(anioCreacion);
        setParadigma(paradigma);
        setCaracteristica(caracteristica);
    }

    public void mostrarCaracteristica() {
        System.out.println(
                "Característica: " + getCaracteristica()
        );
    }
}