package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker implements Store {
    private static SingleTracker instance;
    private final MemTracker tracker = new MemTracker();

    private SingleTracker() {
    }

    public static SingleTracker getInstance() {
        if (instance == null) {
            instance = new SingleTracker();
        }
        return instance;
    }

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
