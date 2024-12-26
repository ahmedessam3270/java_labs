package util;

import java.util.Scanner;

public class MenuSystem {
    private Scanner scanner;

    public MenuSystem() {
        scanner = new Scanner(System.in);
    }

    public void displayMainMenu() {
        System.out.println("\n=== Library Management System ===");
        System.out.println("1. Manage Library Items");
        System.out.println("2. Manage Clients");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public void displayItemMenu() {
        System.out.println("\n=== Library Items Management ===");
        System.out.println("1. Add Book");
        System.out.println("2. Add Magazine");
        System.out.println("3. Display All Items");
        System.out.println("4. Remove Item");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    public void displayClientMenu() {
        System.out.println("\n=== Client Management ===");
        System.out.println("1. Add Client");
        System.out.println("2. Display All Clients");
        System.out.println("3. Remove Client");
        System.out.println("0. Back to Main Menu");
        System.out.print("Enter your choice: ");
    }

    public int getChoice() {
        return scanner.nextInt();
    }

    public void closeScanner() {
        scanner.close();
    }
}