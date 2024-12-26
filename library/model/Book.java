package model;

public class Book extends LibraryItem {
    private String author;
    private String isbn;

    public Book(int id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public String getItemDetails() {
        return String.format("Book [ID: %d, Title: %s, Author: %s, ISBN: %s]",
                id, title, author, isbn);
    }
}