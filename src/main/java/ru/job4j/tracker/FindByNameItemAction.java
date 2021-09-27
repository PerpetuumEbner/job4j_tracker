package ru.job4j.tracker;

public class FindByNameItemAction implements UserAction {
    @Override
    public String name() {
        return "Find items by Name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        String name = input.askStr("Enter name: ");
        for (Item item : tracker.findByName(name)) {
            System.out.println(item);
        }
        return true;
    }
}