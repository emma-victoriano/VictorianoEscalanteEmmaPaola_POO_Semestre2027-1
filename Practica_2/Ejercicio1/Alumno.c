public class Alumno {
    /**
     * Atributos
     * */
    int edad;
    float promedio;
    String nombre, semestre, sexo; //Se agrega otra variable que guardara el sexo

    /**
     * Constructores
     * */
    public Alumno(){}

    public Alumno(int edad, float promedio, String nombre, String semestre, String sexo){
        this.edad = edad;
        this.promedio = promedio;
        this.nombre = nombre;
        this.semestre = semestre;
        this.sexo = sexo;
    }

    /**
     * Setters
     * */

    public void setEdad(int edad){
        this.edad = edad;
    }

    public void setPromedio(float promedio){
        this.promedio = promedio;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setSemestre(String semestre){
        this.semestre = semestre;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    /**
     * Getters
     * */

    public int getEdad(){
        return edad;
    }

    public float getPromedio(){
        return promedio;
    }

    public String getNombre(){
        return nombre;
    }

    public String getSemestre(){
        return semestre;
    }

    public String getSexo(){
        return sexo;
    }
}
