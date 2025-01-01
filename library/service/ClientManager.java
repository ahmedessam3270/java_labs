package service;

import model.Client;
import model.LibraryItem;
import java.util.ArrayList;
import java.util.List;
import exception.ItemNotFoundException;

public class ClientManager implements CRUDOperations<Client> {
    private List<Client> clients;

    public ClientManager() {
        this.clients = new ArrayList<>();
        System.out.println("Client Manager initialized");
    }

    @Override
    public void create(Client client) {
        if (exists(client.getId())) {
            throw new IllegalArgumentException("Client with ID " + client.getId() + " already exists");
        }
        clients.add(client);
    }

    @Override
    public Client read(int id) throws ItemNotFoundException {
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Client with ID " + id + " not found"));
    }

    @Override
    public void update(Client client) throws ItemNotFoundException {
        delete(client.getId());
        clients.add(client);
    }

    @Override
    public void delete(int id) throws ItemNotFoundException {
        Client client = read(id);
        clients.remove(client);
    }

    @Override
    public boolean exists(int id) {
        return clients.stream().anyMatch(client -> client.getId() == id);
    }

    public void displayAllClients() {
        if (clients.isEmpty()) {
            System.out.println("No clients registered.");
            return;
        }
        // Change from println to direct method call
        clients.forEach(Client::getClientDetails);
    }

    public void borrowItem(int clientId, LibraryItem item) throws ItemNotFoundException {
        Client client = read(clientId);
        client.borrowItem(item);
    }

    public void returnItem(int clientId, LibraryItem item) throws ItemNotFoundException {
        Client client = read(clientId);
        client.returnItem(item);
    }
}