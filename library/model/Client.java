package model;

public class Client {
    private int id;
    private String name;
    private String email;

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getClientDetails() {
        return String.format("Client [ID: %d, Name: %s, Email: %s]",
                id, name, email);
    }
}