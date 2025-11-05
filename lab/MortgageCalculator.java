package lab;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter loan ammount");
        int ammount = scanner.nextInt();
        System.out.println("Enter loan  time period[in years]");
        int year=scanner.nextInt();
        System.out.println("Enter yearly interest rate");
        double intrest =scanner.nextDouble();
        int n = year*12;
        double r= intrest/100/12;
        double Nomi=r*Math.pow(1+r, n);
        double Dnomi=Math.pow(1+r,n)-1;

        double mortgage=ammount*Nomi/Dnomi;

        System.out.println("Your monthly mortgage is "+mortgage);


    }
    
}
