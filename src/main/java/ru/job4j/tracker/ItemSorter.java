package ru.job4j.tracker;

import java.util.*;

public class ItemSorter {
    public void sortComparable(List<Item> items) {
        Collections.sort(items);
    }

    public void sortComparator(List<Item> items) {
        Collections.sort(items, new SortByNameItem());
    }
}