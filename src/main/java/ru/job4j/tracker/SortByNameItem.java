package ru.job4j.tracker;

import java.util.Comparator;

public class SortByNameItem implements Comparator<Item> {
    @Override
    public int compare(Item firstItem, Item secondItem) {
        return secondItem.getName().compareTo(firstItem.getName());
    }
}