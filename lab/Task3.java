package lab;
import java.util.Scanner;

public class Task3 {
    public static void main (String [] args)
    {
       Scanner sc= new Scanner(System.in);
      System.out.println("Enter temperture in Celsius");
     float temp=sc.nextFloat();
    
     double  faren=(temp*1.8)+32;

     System.out.println("Temperture in  Farhrenheit " +faren);
     





    }
    
}
