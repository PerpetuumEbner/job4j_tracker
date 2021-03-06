package ru.job4j.tracker;

import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindByNameActionExecuteTest {
    @Test
    public void whenNameActionExecute() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        String name = "New item";
        Item item = new Item(name);
        tracker.add(item);
        FindByNameItemAction find = new FindByNameItemAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find items by name ====" + ln + item + ln));
        assertThat(tracker.findAll().get(0), is(item));
    }
}