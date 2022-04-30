package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdItemActionTest {

    @Test
    public void execute() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("New item");
        tracker.add(item);
        FindByIdItemAction find = new FindByIdItemAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("1");
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Find item by id ====" + ln + item + ln));
        assertThat(tracker.findAll().get(0), is(item));
    }
}