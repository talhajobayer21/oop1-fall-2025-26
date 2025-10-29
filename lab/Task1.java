// A teacher enters the scores of three students ,write a programme to calculate  and display the avg score with two decimal

package lab;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter marks for student 1");
        double marks1= scanner.nextDouble();
        System.out.println("Enter Marks for student 2");
        double marks2= scanner.nextDouble();
        System.out.println("Enter marks for for student 3");
        double marks3=scanner.nextDouble();

        double sum=marks1+marks2+marks3;
        double avarege=sum/3;

        System.out.println("total marks  " +sum);
        System.out.println("Averege marks  " +avarege);


    }
    
}
 