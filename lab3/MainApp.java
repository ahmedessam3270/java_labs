import lab3Packages.*;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a temperature in Celsius: ");
        double inputTemp = scanner.nextDouble();

        TemperatureConverter converter = new TemperatureConverter();
        double outputTemp = converter.apply(inputTemp);
        System.out.println("Temperature in Celsius: " + inputTemp);
        System.out.println("Temperature in Fahrenheit: " + outputTemp);

        
        System.out.println("\nNow, enter coefficients for the quadratic equation ax^2 + bx + c = 0:");

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        try{
        QuadraticSolver solver = new QuadraticSolver();
        double[] coefficients = { a, b, c };
        double[] solutions = solver.apply(coefficients);

        System.out.println("First Solution: " + solutions[0]);
        System.out.println("Second Solution: " + solutions[1]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}