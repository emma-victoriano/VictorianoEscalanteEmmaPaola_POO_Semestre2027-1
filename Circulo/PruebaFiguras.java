public class PruebaFiguras {

    public static void main(String[] args) {
        Circulo cir=new Circulo();
        cir.setRadio(7.2f);
        System.out.println("El area es " + cir.area());
    }

}

public void setRadio(float radio) {
    if(radio < 0) {
        radio = 0;
    }
    this.radio = radio;
}
