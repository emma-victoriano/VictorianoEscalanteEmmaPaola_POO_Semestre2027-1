import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        
        System.out.println("Convierte grados celcius a fahrenheit");
        System.out.print("Ingresa la temperatura en grados Celsius: ");
        double celsius=teclado.nextDouble();
        
        double fahrenheit=(celsius*9/5)+32;
        
        System.out.println("La temperatura en Fahrenheit es: "+fahrenheit+"°F");
        teclado.close();
    }
}
