// library/model/LibraryItem.java
package model;

public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected int stock;
    protected boolean isAvailable;

    public LibraryItem(int id, String title, int stock) {
        this.id = id;
        this.title = title;
        this.stock = stock;
        this.isAvailable = true;
    }

    // Existing getters...

    public boolean isAvailable() {
        return stock > 0;
    }

    public void decreaseStock() {
        if (stock > 0) {
            stock--;
        }
    }

    public void increaseStock() {
        stock++;
    }

    public abstract String getItemDetails();
}