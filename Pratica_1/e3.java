import java.util.Scanner;
public class Tablas_Multiplicacion
{
    public static void main (String args[])
    {
        Scanner teclado=new Scanner (System.in);
        System.out.println ("Este programa calcula la tabla de multiplicar de cualquier numero");
        int n,c,m;
        System.out.println ("digita el numero");
        n= teclado.nextInt();
        for (c = 1; c <= 10; c = c + 1)
        {
            m= n*c;
            System.out.println ("El resultado es: "+m);
        }
    }
}