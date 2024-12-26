// library/service/ClientManager.java
package service;

import interfaces.CRUDOperations;
import model.Client;
import model.LibraryItem;
import exception.ItemNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ClientManager implements CRUDOperations<Client> {
    private List<Client> clients;

    public ClientManager() {
        clients = new ArrayList<>();
    }

    @Override
    public void create(Client client) {
        if (clients.stream().noneMatch(c -> c.getId() == client.getId())) {
            clients.add(client);
        } else {
            throw new IllegalArgumentException("Client with ID " + client.getId() + " already exists");
        }
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
        Client existingClient = read(client.getId());
        clients.set(clients.indexOf(existingClient), client);
    }

    @Override
    public void delete(int id) throws ItemNotFoundException {
        Client client = read(id);
        clients.remove(client);
    }

    public void borrowItem(int clientId, LibraryItem item) throws Exception {
        Client client = read(clientId);
        if (!client.canBorrowMore()) {
            throw new Exception("Client has reached maximum borrowing limit");
        }
        if (!item.isAvailable()) {
            throw new Exception("Item is not available for borrowing");
        }
        
        client.borrowItem(item);
        item.decreaseStock();
    }

    public void returnItem(int clientId, LibraryItem item) throws Exception {
        Client client = read(clientId);
        if (!client.getBorrowedItems().contains(item)) {
            throw new Exception("Client has not borrowed this item");
        }
        
        client.returnItem(item);
        item.increaseStock();
    }
}