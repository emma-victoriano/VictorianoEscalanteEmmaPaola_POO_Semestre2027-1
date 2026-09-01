import java.util.Scanner;

public class Cuadrado {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        
        System.out.print("Ingresa la medida de un lado (en cm ): ");
        int lado=teclado.nextInt();
        int area=lado*lado;
        int perimetro=lado*4;
        
        System.out.println("El área del cuadrado es: " + area+ "cm²");
        System.out.println("El perímetro del cuadrado es: " + perimetro+ "cm");

        teclado.close();
    }
}
