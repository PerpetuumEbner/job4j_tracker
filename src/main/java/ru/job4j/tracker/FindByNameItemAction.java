package ru.job4j.tracker;

public class FindByNameItemAction implements UserAction {
    private final Output output;

    public FindByNameItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find items by Name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        for (Item item : tracker.findByName(name)) {
            output.println(item);
        }
        return true;
    }
}