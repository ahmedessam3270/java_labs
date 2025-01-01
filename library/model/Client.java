package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String email;
    private String contactNumber;
    private List<LibraryItem> borrowedItems;

    // Updated constructor
    public Client(int id, String name, String email, String contactNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.borrowedItems = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }
    
    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
    
    public List<LibraryItem> getBorrowedItems() {
        return new ArrayList<>(borrowedItems);
    }

    public void displayBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("No items currently borrowed.");
            return;
        }
        
        System.out.println("\nBorrowed Items for Client ID " + id + " (" + name + "):");
        System.out.println("----------------------------------------");
        for (LibraryItem item : borrowedItems) {
            System.out.println("ID: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Type: " + (item instanceof Book ? "Book" : "Magazine"));
            System.out.println("----------------------------------------");
        }
    }

    public void getClientDetails() {
        System.out.println("\n=== Client Details ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Number of Borrowed Items: " + borrowedItems.size());
        System.out.println("=====================");
        
    }

    // Add getter and setter for contactNumber
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", borrowedItems=" + borrowedItems +
                '}';
    }
}