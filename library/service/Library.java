package service;

import exception.ItemNotFoundException;
import model.LibraryItem;
import java.util.ArrayList;
import java.util.List;

public class Library<T extends LibraryItem> implements CRUDOperations<T> {
    private List<T> items;

    public Library() {
        items = new ArrayList<>();
    }

    @Override
    public void create(T item) {
        if (exists(item.getId())) {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " already exists");
        }
        items.add(item);
    }

    @Override
    public T read(int id) throws ItemNotFoundException {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }

    @Override
    public void update(T item) throws ItemNotFoundException {
        int index = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == item.getId()) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new ItemNotFoundException("Item with ID " + item.getId() + " not found");
        }
        items.set(index, item);
    }

    @Override
    public void delete(int id) throws ItemNotFoundException {
        T item = read(id);
        items.remove(item);
    }

    @Override
    public boolean exists(int id) {
        return items.stream().anyMatch(item -> item.getId() == id);
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        items.forEach(item -> System.out.println(item.getItemDetails()));
    }

    public List<T> getAvailableItems() {
        return items.stream()
                .filter(LibraryItem::isAvailable)
                .toList();
    }

    public void displayAvailableItems() {
        List<T> availableItems = getAvailableItems();
        if (availableItems.isEmpty()) {
            System.out.println("No items available for borrowing.");
            return;
        }
        System.out.println("Available items:");
        availableItems.forEach(item -> System.out.println(item.getItemDetails()));
    }

    public void borrowItem(int itemId) throws ItemNotFoundException {
        T item = read(itemId);
        if (!item.isAvailable()) {
            throw new IllegalStateException("Item is not available for borrowing");
        }
        item.setAvailable(false);
    }

    public void returnItem(int itemId) throws ItemNotFoundException {
        T item = read(itemId);
        if (item.isAvailable()) {
            throw new IllegalStateException("Item is already available");
        }
        item.setAvailable(true);
    }
}