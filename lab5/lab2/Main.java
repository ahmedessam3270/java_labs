import java.util.Scanner;

import lab2Package.ContainsOnlyAlphabet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide us with a string");

        String input = scanner.nextLine();

        scanner.close();

         
        boolean isAlphabet = ContainsOnlyAlphabet.containsOnlyAlphabet(input); 

        if(isAlphabet) System.out.println("The string contains only alphabets");
        else System.out.println("The string contains non-alphabets");
    }
}