package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeleteItemActionTest {

    @Test
    public void execute() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));
        DeleteItemAction del = new DeleteItemAction(output);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("1");
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("=== Delete item ====" + ln + "successfully" + ln));
        assertThat(tracker.findAll().size(), is(0));
    }
}