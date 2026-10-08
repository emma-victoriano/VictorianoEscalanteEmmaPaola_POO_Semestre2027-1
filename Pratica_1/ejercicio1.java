import java.util.Scanner;
public class Cuadrado
{
    public static void main (String args[])
    {
        int a,b;
        Scanner teclado = new Scanner (System.in);
        System.out.println("Este programa calcula el area de un cuadrado");
        System.out.print("Digita la medida de un lado: ");
        a = teclado.nextInt();
        b = a * a;
        System.out.println("El area del cuadrado es: " +b);
    }
}
