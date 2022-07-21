package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class HbmTrackerTest {

    @Test
    public void whenAdd() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item");
        tracker.add(item);
        List<Item> listItems = tracker.findAll();
        assertEquals(listItems.get(0), item);
    }

    @Test
    public void replace() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item");
        Item replaceItem = new Item("replaceItem");
        tracker.add(item);
        assertTrue(tracker.replace(item.getId(), replaceItem));
    }

    @Test
    public void delete() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("item");
        tracker.add(item);
        assertTrue(tracker.delete(item.getId()));
        List<Item> listItems = tracker.findAll();
        assertEquals(listItems.size(), 0);
    }

    @Test
    public void findAll() {
        HbmTracker tracker = new HbmTracker();
        Item firstItem = new Item("1", "firstItem");
        Item secondItem = new Item("2", "secondItem");
        Item thirdItem = new Item("3", "thirdItem");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        List<Item> listItems = tracker.findAll();
        assertEquals(List.of(secondItem, firstItem, thirdItem), listItems);
    }

    @Test
    public void findByName() {
        HbmTracker tracker = new HbmTracker();
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("item");
        Item thirdItem = new Item("item");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        List<Item> listItems = tracker.findByName("item");
        assertEquals(List.of(secondItem, thirdItem), listItems);
    }

    @Test
    public void findById() {
        HbmTracker tracker = new HbmTracker();
        Item firstItem = new Item("firstItem");
        Item secondItem = new Item("secondItem");
        Item thirdItem = new Item("thirdItem");
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertEquals(tracker.findById(secondItem.getId()), secondItem);
    }
}