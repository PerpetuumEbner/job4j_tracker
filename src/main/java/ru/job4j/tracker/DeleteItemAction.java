package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output output;

    public DeleteItemAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Delete item ====");
        String id = input.askStr("Enter id: ");
        if (tracker.delete(id)) {
            output.println("successfully");
        } else {
            output.println("error");
        }
        return true;
    }
}