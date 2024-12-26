package service;

import model.Client;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {
    private List<Client> clients;

    public ClientManager() {
        clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void removeClient(int id) {
        clients.removeIf(client -> client.getId() == id);
    }

    public void displayAllClients() {
        clients.forEach(client -> System.out.println(client.getClientDetails()));
    }
}