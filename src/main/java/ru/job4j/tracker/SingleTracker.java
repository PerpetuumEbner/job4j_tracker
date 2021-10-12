package ru.job4j.tracker;

import java.util.List;

public class SingleTracker implements Store {
    private final MemTracker tracker = new MemTracker();

    @Override
    public void init() {
    }

    @Override
    public void close() throws Exception {
    }

    @Override
    public Item add(Item item) {
        return tracker.add(item);
    }

    @Override
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    @Override
    public boolean delete(String id) {
        return tracker.delete(id);
    }

    @Override
    public List<Item> findAll() {
        return tracker.findAll();
    }

    @Override
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    @Override
    public Item findById(String id) {
        return tracker.findById(id);
    }


}
