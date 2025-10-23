import java.util.Scanner;

public class EMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter loan amount (principal): ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual interest rate (in %): ");
        double annualRate = sc.nextDouble();

        System.out.print("Enter loan period (in years): ");
        int years = sc.nextInt();

        // Convert annual interest rate to monthly
        double monthlyRate = (annualRate / 12) / 100;
        int months = years * 12;

        // EMI formula: [P x R x (1+R)^N] / [(1+R)^N – 1]
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                     (Math.pow(1 + monthlyRate, months) - 1);

        System.out.printf("\nYour monthly EMI is: %.2f\n", emi);
        sc.close();
    }
}
