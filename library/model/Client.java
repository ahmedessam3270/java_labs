// package model;

// public class Client {
//     private int id;
//     private String name;
//     private String email;

//     public Client(int id, String name, String email) {
//         this.id = id;
//         this.name = name;
//         this.email = email;
//     }

//     public int getId() {
//         return id;
//     }

//     public String getClientDetails() {
//         return String.format("Client [ID: %d, Name: %s, Email: %s]",
//                 id, name, email);
//     }
// }

// library/model/Client.java
package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;
    private static final int MAX_BORROWED_ITEMS = 5;

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
    }

    public boolean canBorrowMore() {
        return borrowedItems.size() < MAX_BORROWED_ITEMS;
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

        public int getId() {
        return id;
    }

    public String getClientDetails() {
        return String.format("Client [ID: %d, Name: %s, Email: %s]",
                id, name, email);
    }

}