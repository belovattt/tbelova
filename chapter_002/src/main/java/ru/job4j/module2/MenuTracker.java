package ru.job4j.module2;

import java.util.Arrays;

/**
 * Class MenuTracker реализует меню.
 *
 * @author Tatyana Belova
 * @since 5.08.2017
 */
public class MenuTracker {
    /**
     * input.
     */
    private Input input;
    /**
     * output.
     */
    private Output output;
    /**
     * tracker.
     */
    private Tracker tracker;
    /**
     * массив действий пользователя.
     */
    private UserAction[] actions = new UserAction[6];
    /**
     * номер последнего пункта меню.
     */
    private int maxvalue = actions.length - 1;

    /**
     * метод возвращает maxvalue.
     *
     * @return maxvalue
     */
    public int getMaxvalue() {
        return this.maxvalue;
    }

    /**
     * конструктор.
     *
     * @param input   - ввод данных
     * @param tracker - tracker
     */
    public MenuTracker(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * инициализация
     *
     * @param input   - input
     * @param tracker - tracker
     */
    public void init(Input input, Output output, Tracker tracker) {

    }

    /**
     * заполнение массива actions.
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.FindItemById();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindByName();
        this.actions[5] = new ShowAll();
    }

    /**
     * вывод меню на экран.
     */
    public void showMenu() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * выбор пользователя.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.output, this.tracker);
    }

    private class AddItem implements UserAction {

        /**
         * выбор пункта меню.
         */
        @Override
        public int key() {
            return 0;
        }

        /**
         * действие.
         *
         * @param input   - ввод
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            Item item = new Item();
            item.setName(input.ask("Input item's name "));
            item.setDescription(input.ask("Input item's description "));
            item.setCreated(System.currentTimeMillis());
            item.setId("" + System.currentTimeMillis());
            String[] forcomments = new String[10];
            int i = 0;
            String end;
            do {
                forcomments[i++] = input.ask("Input item's comment ");
                end = input.ask("Is it all? (y/n) ");
            } while (end.equals("n"));
            item.setComments(Arrays.copyOf(forcomments, i));
            item = tracker.add(item);


        }

        /**
         * вывод информации .
         */
        @Override
        public String info() {
            return "0: Add item";
        }
    }

    private static class FindItemById implements UserAction {

        /**
         * выбор пункта меню.
         */
        @Override
        public int key() {
            return 1;
        }

        /**
         * действие.
         *
         * @param input   - ввод
         * @param output  - вывод
         * @param tracker - tracker
         */
        @Override
        public void execute(Input input, Output output, Tracker tracker) {
            Item item = tracker.findById(input.ask("Enter item's id"));
            if (item == null) {
                output.write("Item not found");
            } else {
                output.write("Item's name " + item.getName());
                output.write("Item's description " + item.getDescription());
                output.write("Item was created " + item.getCreated());
                output.write("Item's id " + item.getId());
                output.write("Item's comments:");
                for (String s : item.getComments()) {
                    output.write(s);
                }
            }

        }

        /**
         * вывод информации .
         */
        @Override
        public String info() {
            return "1: Find item by id";
        }
    }


}

class EditItem implements UserAction {
    /**
     * выбор пункта меню.
     */
    @Override
    public int key() {
        return 1;
    }

    /**
     * действие.
     *
     * @param input   - ввод
     * @param output  - вывод
     * @param tracker - tracker
     */
    @Override
    public void execute(Input input, Output output, Tracker tracker) {
        Item item = tracker.findById(input.ask("Please, enter item's id "));
        if (item == null) {
            output.write("Item doesn't exist");
        } else {
            item.setName(input.ask("Input item's new name "));
            item.setDescription(input.ask("Input item's new description "));
            item.setCreated(System.currentTimeMillis());
            String[] forcomments = new String[10];
            int i = 0;
            String end;
            do {
                forcomments[i++] = input.ask("Input item's new comment ");
                end = input.ask("Is it all? (y/n) ");
            } while (end.equals("n"));
            item.setComments(Arrays.copyOf(forcomments, i));
            tracker.update(item);
        }
    }

    /**
     * вывод информации .
     */
    @Override
    public String info() {
        return "2: Edit item";
    }
}

class DeleteItem implements UserAction {
    /**
     * выбор пункта меню.
     */
    @Override
    public int key() {
        return 3;
    }

    /**
     * действие.
     *
     * @param input   - ввод
     * @param output  - вывод
     * @param tracker - tracker
     */
    @Override
    public void execute(Input input, Output output, Tracker tracker) {
        String id = input.ask("Please, enter item's id ");
        Item item = tracker.findById(id);
        if (item == null) {
            output.write("Item doesn't exist");
        } else {
            tracker.delete(id);
        }
    }

    /**
     * вывод информации .
     */
    @Override
    public String info() {
        return "3: Delete item";
    }
}

class FindByName implements UserAction {
    /**
     * выбор пункта меню.
     */
    @Override
    public int key() {
        return 4;
    }

    /**
     * действие.
     *
     * @param input   - ввод
     * @param output  - вывод
     * @param tracker - tracker
     */
    @Override
    public void execute(Input input, Output output, Tracker tracker) {
        String name = input.ask("Please, enter item's name");
        for (Item item : tracker.findByName(name)) {
            output.write("Item's name " + item.getName());
            output.write("Item's description " + item.getDescription());
            output.write("Item was created " + item.getCreated());
            output.write("Item's id " + item.getId());
            output.write("Item's comments:");
            for (String s : item.getComments()) {
                output.write(s);
            }
        }
    }

    /**
     * вывод информации .
     */
    @Override
    public String info() {
        return "4: Find item by name";
    }
}

class ShowAll implements UserAction {
    /**
     * выбор пункта меню.
     */
    @Override
    public int key() {
        return 5;
    }

    /**
     * действие.
     *
     * @param input   - ввод
     * @param output  - вывод
     * @param tracker - tracker
     */
    @Override
    public void execute(Input input, Output output, Tracker tracker) {
        for (Item item : tracker.getAll()) {
            output.write("Item's name " + item.getName());
            output.write("Item's description " + item.getDescription());
            output.write("Item was created " + item.getCreated());
            output.write("Item's id " + item.getId());
            output.write("Item's comments:");
            for (String s : item.getComments()) {
                output.write(s);
            }
        }
    }

    /**
     * вывод информации .
     */
    @Override
    public String info() {
        return "5: Show all items";
    }
}


