package _01_introduction_to_java.practice;

import java.util.Scanner;

public class WeightOfBodyCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight, height, bmi;
        System.out.println("Your weight (in kilogram): ");
        weight = Double.parseDouble(sc.nextLine());
        System.out.println("Your height (in meter): ");
        height = Double.parseDouble(sc.nextLine());
        bmi = weight / Math.pow(height, 2);
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if(bmi < 18)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if(bmi < 25)
            System.out.printf("%-20s%s", bmi, "Normal");
        else if(bmi < 30)
            System.out.printf("%-20s%s", bmi, "Overweight");
        else
            System.out.printf("%-20s%s", bmi, "Obese");
    }
}
