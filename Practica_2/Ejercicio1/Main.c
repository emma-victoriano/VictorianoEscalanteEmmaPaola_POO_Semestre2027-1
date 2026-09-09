import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // Se crea el arreglo de 10 alumnos
        Alumno[] alumnos = new Alumno[10];

        // Se crean los primeros dos alumnos con el constructor lleno, pues están ocupados
        alumnos[0] = new Alumno(19, 9.5f, "Claudia", "5", "M");
        alumnos[1] = new Alumno(18, 8.7f, "Carlos", "5", "H");

        // Variable para recorrer el arreglo
        int i = 2; //Inicia en dos porque los primeros dos datos ya estan ocupados

        // Se hace el llenado los 8 alumnos restantes usando while
        while (i < alumnos.length) {
            //Se realiza mientras i sea menor a el tamaño del arreglo, es decir i<10

            // Se crea el objeto mediante el constructor vacío y recordar que i=2
            alumnos[i] = new Alumno();
            System.out.println("\nAlumno " + (i + 1));

            // Se llenan los datos usando setters, por lo que el objeto que se crea queda lleno
            System.out.print("Nombre: ");
            alumnos[i].setNombre(entrada.nextLine());

            System.out.print("Edad: ");
            alumnos[i].setEdad(entrada.nextInt());

            System.out.print("Promedio: ");
            alumnos[i].setPromedio(entrada.nextFloat());

            System.out.print("Semestre: ");
            entrada.nextLine();
            alumnos[i].setSemestre(entrada.nextLine());

            // Sexo y se usan mayusculas o minisculas para que el usuario escoja libremente
            System.out.print("Sexo (H/h o M/m): ");
            String sexo = entrada.nextLine(); //Dato dado por el usuario

            // Condicional if-else para asignar el sexo y poder leer minusculas y mayusculas
            if (sexo.equals("H") || sexo.equals("h")) { //La variable solicitada por el usuario contiene H o h?
                alumnos[i].setSexo("H"); //Si se cumple ser guarda H y si no, se guarda M
            } else {
                alumnos[i].setSexo("M");
            }

            // Incrementar el contador
            i++;
        }

        // Imprimir el arreglo usando for
        System.out.println("\nLISTA DE ALUMNOS");

        for (i = 0; i < alumnos.length; i++) {

            System.out.println("\nAlumno " + (i + 1));
            System.out.println("Nombre: " + alumnos[i].getNombre());
            System.out.println("Edad: " + alumnos[i].getEdad());
            System.out.println("Promedio: " + alumnos[i].getPromedio());
            System.out.println("Semestre: " + alumnos[i].getSemestre());
            System.out.println("Sexo: " + alumnos[i].getSexo());
        }

        entrada.close();
    }
}
