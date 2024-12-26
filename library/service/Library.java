package service;

import exception.ItemNotFoundException;
import model.LibraryItem;
import java.util.ArrayList;
import java.util.List;

public class Library<T extends LibraryItem> {
    private List<T> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int id) throws ItemNotFoundException {
        return items.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + id + " not found"));
    }

    public void displayAllItems() {
        items.forEach(item -> System.out.println(item.getItemDetails()));
    }

    public void removeItem(int id) throws ItemNotFoundException {
        T item = getItem(id);
        items.remove(item);
    }
}