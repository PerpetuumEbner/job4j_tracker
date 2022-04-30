package ru.job4j.tracker;

public class CreateItemAction implements UserAction {
    private final Output output;

    public CreateItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        output.println("Добавленая заявка: " + item);
        return true;
    }
}