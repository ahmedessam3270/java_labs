// library/service/Library.java
package service;

import interfaces.CRUDOperations;
import exception.ItemNotFoundException;
import model.LibraryItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library<T extends LibraryItem> implements CRUDOperations<T> {
    private List<T> items;

    public Library() {
        items = new ArrayList<>();
    }

    @Override
    public void create(T item) {
        if (items.stream().noneMatch(i -> i.getId() == item.getId())) {
            items.add(item);
        } else {
            throw new IllegalArgumentException("Item with ID " + item.getId() + " already exists");
        }
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
        T existingItem = read(item.getId());
        items.set(items.indexOf(existingItem), item);
    }

    @Override
    public void delete(int id) throws ItemNotFoundException {
        T item = read(id);
        items.remove(item);
    }

    public void displayAllItems() {
        items.forEach(item -> System.out.println(item.getItemDetails()));
    }

    public List<T> getAvailableItems() {
        return items.stream()
                .filter(LibraryItem::isAvailable)
                .toList();
    }
}