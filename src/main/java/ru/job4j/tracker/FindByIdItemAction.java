package ru.job4j.tracker;

public class FindByIdItemAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        System.out.println(item);
        return true;
    }
}