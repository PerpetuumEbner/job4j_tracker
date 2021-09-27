package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"one", "1"}));
        input.askInt("Enter");
        assertThat(
                byteArrayOutputStream.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(printStream);
    }

    @Test
    public void whenMaxInput() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
        ValidateInput input = new ValidateInput(new StubInput(new String[] {"5", "1"}));
        input.askInt("Enter", 5);
        assertThat(
                byteArrayOutputStream.toString(),
                is(String.format("Please select key from menu.%n"))
        );
        System.setOut(printStream);
    }
}