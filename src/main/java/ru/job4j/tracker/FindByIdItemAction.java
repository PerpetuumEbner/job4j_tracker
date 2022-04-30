package ru.job4j.tracker;

public class FindByIdItemAction implements UserAction {
    private final Output output;

    public FindByIdItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Find item by id ====");
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        output.println(item);
        return true;
    }
}