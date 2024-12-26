// LibraryManagementSystem.java

import exception.ItemNotFoundException;
import model.*;
import service.*;
import util.MenuSystem;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library<LibraryItem> library;
    private static ClientManager clientManager;
    private static MenuSystem menuSystem;
    private static Scanner scanner;

    public static void main(String[] args) {
        initialize();
        runSystem();
        cleanup();
    }

    private static void initialize() {
        library = new Library<>();
        clientManager = new ClientManager();
        menuSystem = new MenuSystem();
        scanner = new Scanner(System.in);
    }

    private static void runSystem() {
        boolean running = true;
        while (running) {
            try {
                menuSystem.displayMainMenu();
                int choice = menuSystem.getChoice();
                
                switch (choice) {
                    case 1:
                        handleLibraryItems();
                        break;
                    case 2:
                        handleClients();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear scanner buffer
            }
        }
    }

    private static void handleLibraryItems() {
        boolean managing = true;
        while (managing) {
            menuSystem.displayItemMenu();
            int choice = menuSystem.getChoice();
            
            try {
                switch (choice) {
                    case 1:
                        addBook();
                        break;
                    case 2:
                        addMagazine();
                        break;
                    case 3:
                        library.displayAllItems();
                        break;
                    case 4:
                        removeItem();
                        break;
                    case 0:
                        managing = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void handleClients() {
        boolean managing = true;
        while (managing) {
            menuSystem.displayClientMenu();
            int choice = menuSystem.getChoice();
            
            try {
                switch (choice) {
                    case 1:
                        addClient();
                        break;
                    case 2:
                        clientManager.displayAllClients();
                        break;
                    case 3:
                        removeClient();
                        break;
                    case 0:
                        managing = false;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void cleanup() {
        scanner.close();
        menuSystem.closeScanner();
    }

    // Helper methods for CRUD operations
    private static void addBook() {
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        library.addItem(new Book(id, title, author, isbn));
        System.out.println("Book added successfully!");
    }

    private static void addMagazine() {
        System.out.print("Enter magazine ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter issue number: ");
        int issue = scanner.nextInt();

        library.addItem(new Magazine(id, title, publisher, issue));
        System.out.println("Magazine added successfully!");
    }

    private static void removeItem() throws ItemNotFoundException {
        System.out.print("Enter item ID to remove: ");
        int id = scanner.nextInt();
        library.removeItem(id);
        System.out.println("Item removed successfully!");
    }

    private static void addClient() {
        System.out.print("Enter client ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        clientManager.addClient(new Client(id, name, email));
        System.out.println("Client added successfully!");
    }

    private static void removeClient() {
        System.out.print("Enter client ID to remove: ");
        int id = scanner.nextInt();
        clientManager.removeClient(id);
        System.out.println("Client removed successfully!");
    }
}