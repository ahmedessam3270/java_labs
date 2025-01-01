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

    // Add color constants
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    // Add utility methods for colored output
    private static void printSuccess(String message) {
        System.out.println(ANSI_GREEN + message + ANSI_RESET);
    }
    
    private static void printError(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public static void main(String[] args) {
        initialize();
        runSystem();
        cleanup();
    }

    private static void initialize() {
        scanner = new Scanner(System.in);  
        library = new Library<>();
        clientManager = new ClientManager();
        menuSystem = new MenuSystem(scanner);  
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
                    case 3:
                        handleBorrowing();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Thank you for using the Library Management System!");
                        break;
                    default:
                    printError("Invalid choice! Please try again.");
                }
            } catch (IllegalStateException e) {
                printError("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleLibraryItems() {
        boolean managing = true;
        while (managing) {
            try {
                menuSystem.displayItemMenu();
                int choice = menuSystem.getChoice();
                
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
                    case 5:
                        updateItem(); // New case
                        break;
                    case 0:
                        managing = false;
                        break;
                    default:
                    printError("Invalid choice! Please try again.");
                }
            } catch (ItemNotFoundException e) {
                printError("Error: " + e.getMessage());
            } catch (IllegalStateException e) {
                printError("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleClients() {
        boolean managing = true;
        while (managing) {
            try {
                menuSystem.displayClientMenu();
                int choice = menuSystem.getChoice();
                
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
                    case 4:
                        updateClient(); // New case
                        break;
                    case 0:
                        managing = false;
                        break;
                    default:
                    printError("Invalid choice! Please try again.");
                }
            } catch (ItemNotFoundException e) {
                printError("Error: " + e.getMessage());
            } catch (IllegalStateException e) {
                printError("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleBorrowing() {
        boolean managing = true;
        while (managing) {
            try {
                menuSystem.displayBorrowingMenu();
                int choice = menuSystem.getChoice();
                
                switch (choice) {
                    case 1:
                        handleBorrowItem();
                        break;
                    case 2:
                        handleReturnItem();
                        break;
                    case 3:
                        library.displayAvailableItems();
                        break;
                    case 4:
                        displayClientBorrowedItems();
                        break;
                    case 0:
                        managing = false;
                        break;
                    default:
                    printError("Invalid choice! Please try again.");
                }
            } catch (ItemNotFoundException e) {
                printError("Error: " + e.getMessage());
            } catch (IllegalStateException e) {
                printError("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void handleBorrowItem() throws ItemNotFoundException {
        System.out.println("\n=== Borrow Item ===");
        
        // Display available items
        library.displayAvailableItems();
        
        // Get client ID
        int clientId = readInt("Enter client ID: ");
        Client client = clientManager.read(clientId);
        
        // Get item ID
        int itemId = readInt("Enter item ID to borrow: ");
        
        // Get and validate item
        LibraryItem item = library.read(itemId);
        if (!item.isAvailable()) {
            throw new IllegalStateException("Item is not available for borrowing");
        }
        
        // Process borrowing
        library.borrowItem(itemId);
        clientManager.borrowItem(clientId, item);
        printSuccess("Item borrowed successfully!");
    }

    private static void handleReturnItem() throws ItemNotFoundException {
        System.out.println("\n=== Return Item ===");
        
        // Get client ID
        int clientId = readInt("Enter client ID: ");
        
        // Validate client and display their borrowed items
        Client client = clientManager.read(clientId);
        client.displayBorrowedItems();
        
        if (client.getBorrowedItems().isEmpty()) {
            printError("This client has no items to return.");
            return;
        }
        
        // Get item ID
        int itemId = readInt("Enter item ID to return: ");
        
        // Get and validate item
        LibraryItem item = library.read(itemId);
        
        // Process return
        library.returnItem(itemId);
        clientManager.returnItem(clientId, item);
        printSuccess("Item returned successfully!");
    }

    private static void displayClientBorrowedItems() throws ItemNotFoundException {
        int clientId = readInt("Enter client ID: ");
        Client client = clientManager.read(clientId);
        client.displayBorrowedItems();
    }

    private static void cleanup() {
        if (scanner != null) {
            scanner.close();
        }
    }

    
    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                printError("Please enter a valid number.");
            }
        }
    }

    private static void addBook() {
        System.out.println("\n=== Add New Book ===");
        int id = readInt("Enter book ID: ");
        String title = readString("Enter title: ");
        String author = readString("Enter author: ");
        String isbn = readString("Enter ISBN: ");

        library.create(new Book(id, title, author, isbn));
        printSuccess("Book added successfully!");
    }

    private static void addMagazine() {
        System.out.println("\n=== Add New Magazine ===");
        int id = readInt("Enter magazine ID: ");
        String title = readString("Enter title: ");
        String publisher = readString("Enter publisher: ");
        int issue = readInt("Enter issue number: ");

        library.create(new Magazine(id, title, publisher, issue));
        printSuccess("Magazine added successfully!");
    }

    private static void removeItem() throws ItemNotFoundException {
        int id = readInt("Enter item ID to remove: ");
        library.delete(id);
        printSuccess("Item removed successfully!");
    }

    private static void addClient() {
        System.out.println("\n=== Add New Client ===");
        int id = readInt("Enter client ID: ");
        String name = readString("Enter name: ");
        String email = readString("Enter email: ");
        String contactNumber = readString("Enter contact number: ");        

        clientManager.create(new Client(id, name, email, contactNumber));
        printSuccess("Client added successfully!");
    }

    private static void removeClient() throws ItemNotFoundException {
        int id = readInt("Enter client ID to remove: ");
        clientManager.delete(id);
        printSuccess("Client removed successfully!");
    }

    private static void updateItem() {
        System.out.println("\n=== Update Item ===");
        int itemId = readInt("Enter item ID to update: ");
        try {
            LibraryItem item = library.read(itemId); // First get the existing item
            // Modify the item properties
            library.update(item); // Update the item
        } catch (ItemNotFoundException e) {
            printError("Error: " + e.getMessage());
        }
    }

    private static void updateClient() {
        System.out.print("Enter client ID to update: ");
        int clientId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        try {
            Client client = clientManager.read(clientId);
            boolean updating = true;
            
            while (updating) {
                System.out.println("\n=== Update Client Properties ===");
                System.out.println("1. Update Name (Current: " + client.getName() + ")");
                System.out.println("2. Update Contact Number (Current: " + client.getContactNumber() + ")");
                System.out.println("3. Update Email (Current: " + client.getEmail() + ")");
                System.out.println("0. Finish Updating");
                System.out.print("Enter choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        client.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter new contact number: ");
                        client.setContactNumber(scanner.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter new email: ");
                        client.setEmail(scanner.nextLine());
                        break;
                    case 0:
                        updating = false;
                        break;
                    default:
                    printError("Invalid choice!");
                }
            }
            
            clientManager.update(client);
            printSuccess("Client updated successfully!");
            
        } catch (ItemNotFoundException e) {
            printError("Error: " + e.getMessage());
        }
    }
}