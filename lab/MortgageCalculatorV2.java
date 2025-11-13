package lab;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MortgageCalculatorV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------Mortgage calculator in bdt---------");

        System.out.println("Enter your salary");
        double salary;
        while (true) {
            if (scanner.hasNextDouble()) {
              salary = scanner.nextDouble();
                scanner.nextLine();
                break;
            } 
            else {
                System.out.println("enter a valid input[numerical value]");
                scanner.nextLine();
            }

        }

        System.out.println("Enter your credit score[300-500]");
        int creditsc = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                creditsc =scanner.nextInt();
            scanner.nextLine();
               
                if (creditsc >= 300 && creditsc <= 500) {
                    break;
                }
                 else {
                    System.out.println("Credit score must be between 300-500");
                }
            }
             else {
                System.out.println("Enter a valid credit score[300-500]");
                scanner.nextLine();
            }
        }

        System.out.println("Do you hav enay criminal record ?[true/false]");
        boolean crimalR;
        while (true) {
            if (scanner.hasNextBoolean()) {
                 crimalR =scanner.nextBoolean();
                scanner.nextLine();
                break;
            } 
            else {
                System.out.println("Eneter valid input[only true /false]");
                scanner.nextLine();
            }
        }

        if (creditsc > 300 && !crimalR) {
            System.out.println("Enter your desired loan amount");
            double loanA =scanner.nextDouble();
            if (loanA > salary * 2) {
                System.out.println("Sorry you cant take this ammount ,the lan ammoubt should not be more than twice your salary");
            } 
            else {
                System.out.println("Enter loan  time period[in years]");
                int year =scanner.nextInt();
                System.out.println("Enter yearly interest rate");
                double intrest =scanner.nextDouble();
                int n = year * 12;
                double r = intrest / 100 / 12;
                double Nomi = r * Math.pow(1 + r, n);
                double Dnomi =Math.pow(1 + r, n) - 1;

                double mortgage =loanA * Nomi / Dnomi;
                NumberFormat bdT =NumberFormat.getCurrencyInstance(new Locale("en", "BD"));

                System.out.println("Your monthly mortgage is " +bdT.format(mortgage));
                System.out.println("Your yearly mortgage is "   +bdT.format(mortgage*12));
                  System.out.println("Your total mortgage is " +bdT.format(mortgage*12*year));
            }
        } 
        else {
            System.out.println("Sorry you cant take eloan ,your credit score must be between 300-500 and you must have not any criminal record");
        }

        scanner.close();
    }
}
