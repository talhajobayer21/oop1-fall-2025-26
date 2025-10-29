package lab;
import java.util.Scanner;

public class Task4 {
    public static void main(String []args )
    {
       System.out.println("Enter two number to be swapped");
       Scanner scanner = new Scanner(System.in);
       int a= scanner.nextInt();
       int b=scanner.nextInt();
       System.out.println("Before swap X= "+a);
       System.out.println("Before Swap Y= "+b);

       a=a+b;
       b=a-b;
       a=a-b;
    
       System.out.println("After swap X=  "+a);
       System.out.println("After swap Y= "+b);





    }
    
}
