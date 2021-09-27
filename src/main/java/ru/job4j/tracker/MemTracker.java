package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();

    @Override
    public void init() {

    }

    @Override
    public void close() throws Exception {

    }

    public Item add(Item item) {
        item.setId(generateId());
        items.add(item);
        return item;
    }

    private String generateId() {
        Random random = new Random();
        return String.valueOf(random.nextLong() + System.currentTimeMillis());
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsByName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsByName.add(item);
            }
        }
        return items;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        boolean rls = false;
        int index = indexOf(id);
        if (index != 1) {
            items.set(index, item);
            item.setId(id);
            rls = true;
        }
        return rls;
    }

    public boolean delete(String id) {
        boolean rls = false;
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            rls = true;
        }
        return rls;
    }
}