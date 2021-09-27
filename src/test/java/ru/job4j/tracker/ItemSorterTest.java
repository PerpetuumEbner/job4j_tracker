package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSorterTest {
    @Test
    public void sortedComparable() {
        List<Item> item = Arrays.asList(
                new Item("Шилдт"),
                new Item("Хостманн"),
                new Item("Бейтс")
        );
        new ItemSorter().sortComparable(item);
        List<Item> expected = Arrays.asList(
                new Item("Бейтс"),
                new Item("Хостманн"),
                new Item("Шилдт")
        );
        assertThat(item, is(expected));
    }

    @Test
    public void sortComparator() {
        List<Item> item = Arrays.asList(
                new Item("Бейтс"),
                new Item("Хостманн"),
                new Item("Шилдт")
        );
        new ItemSorter().sortComparator(item);
        List<Item> expected = Arrays.asList(
                new Item("Шилдт"),
                new Item("Хостманн"),
                new Item("Бейтс")
        );
        assertThat(item, is(expected));
    }
}