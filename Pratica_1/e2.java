import java.util.Scanner;
public class Operacion
{
    public static void main (String args[])
    {
        int a,b,c,d,e,f;
        Scanner teclado = new Scanner (System.in);
        System.out.println("Este programa realiza las cuatro operaciones basicas con dos numeros");
        System.out.print("Digita el primer numero: ");
        a = teclado.nextInt();
        System.out.print("Digita el segundo numero: ");
        b = teclado.nextInt();
        c = a + b;
        d = a - b;
        e = a * b;
        f = a / b;
        System.out.println("El resultado de la suma es:  "+c);
        System.out.println("El resultado de la resta es:  "+d);
        System.out.println("El resultado de la multiplicacion es:  "+e);
        System.out.println("El resultado de la division es:  "+f);
    }
}