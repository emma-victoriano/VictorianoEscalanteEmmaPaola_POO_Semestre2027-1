public class PruebaPersona {
    public static void main(String[] args) {
        Persona per1 = new Persona();
        Fecha nac = new Fecha();

        per1.setNombre("Juan");
        per1.setApellido("Perez");

        nac.setDia(15);
        nac.setMes(8);
        nac.setAnio(1950);

        per1.setFNacimiento(nac);

        System.out.println("Nombre: " + per1.getNombre());
        System.out.println("Apellido: " + per1.getApellido());
        System.out.println("Fecha Nacimiento: " + per1.getFNacimiento().getDia() + 
                "/" + per1.getFNacimiento().getMes() + 
                "/" + per1.getFNacimiento().getAnio());
    }
}