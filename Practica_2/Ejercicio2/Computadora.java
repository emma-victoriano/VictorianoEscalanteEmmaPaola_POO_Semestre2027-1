public class Computadora{

    //-------------Atributos----------------

    // Declaramos los atributos 
    String cpu;
    int memoriaRam;
    int almacenamiento;
    int fuenteEnergia;
    boolean gpu;

    //-------------Constructores----------------

    //Creamos un constructor vacio  para permitir crear instancias sin valores iniciales
    public Computadora(){}

    //Constructor completo que recibe e inicializa todos los atributos del objeto al crearse
    public Computadora(int memoriaRam,int almacenamiento,int fuenteEnergia,String cpu,boolean gpu){
        this.memoriaRam=memoriaRam;
        this.almacenamiento=almacenamiento;
        this.fuenteEnergia=fuenteEnergia;
        this.cpu=cpu;
        this.gpu=gpu;
    }

    //-------------Setters----------------
    // Los creamos para poder asignar los valores que nosotros queramos a cada atributo (ponemos uno por cada atributo :))
    public void setMemoriaRam(int memoriaRam){
        this.memoriaRam=memoriaRam;
    }
    public void setAlmacenamiento(int almacenamiento){
        this.almacenamiento=almacenamiento;
    }
    public void setFuenteEnergia(int fuenteEnergia){
        this.fuenteEnergia=fuenteEnergia;
    }
    public void setCpu(String cpu){
        this.cpu=cpu;
    }
    public void setGpu(boolean gpu){
        this.gpu=gpu;
    }

    //-------------Getters----------------
    // Usamos getters para poder  ver el valor almacenado en cada atributo (Igual va uno por cada atributo)
    public int getMemoriaRam(){
        return memoriaRam;
    }
    public int getAlmacenamiento(){
        return almacenamiento;
    }
    public int getFuenteEnergia(){
        return fuenteEnergia;
    }
    public String getCpu(){
        return cpu;
    }
    public boolean getGpu(){
        return gpu;
    }
}
