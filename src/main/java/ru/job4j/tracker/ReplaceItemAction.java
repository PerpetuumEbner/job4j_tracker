package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    private final Output output;

    public ReplaceItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Edit item ====");
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("successfully");
        } else {
            System.out.println("error");
        }
        return true;
    }
}