package model;

public class Magazine extends LibraryItem {
    private String publisher;
    private int issue;

    public Magazine(int id, String title, String publisher, int issue) {
        super(id, title);
        this.publisher = publisher;
        this.issue = issue;
    }

    @Override
    public String getItemDetails() {
        return String.format("Magazine [ID: %d, Title: %s, Publisher: %s, Issue: %d, Available: %s]",
                id, title, publisher, issue, isAvailable);
    }
}