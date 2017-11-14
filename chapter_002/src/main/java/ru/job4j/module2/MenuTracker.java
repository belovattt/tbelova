package ru.job4j.module2;

import java.util.ArrayList;
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
    private ArrayList<UserAction> actions = new ArrayList<>(6);

    /**
     * текущая позиция.
     */
    private int position = 0;

     /**
     * номер последнего пункта меню.
     */


    /**
     * метод возвращает maxvalue.
     *
     * @return maxvalue
     */
    public int getMaxvalue() {
        return this.actions.size() - 1;
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
        this.actions.add(this.new AddItem("Add item", position++));
        this.actions.add(new MenuTracker.FindItemById("Find item by id", position++)) ;
        this.actions.add(new EditItem("Edit item", position++));
        this.actions.add(new DeleteItem("Delete item", position++));
        this.actions.add(new FindByName("Find item by name", position++));
        this.actions.add(new ShowAll("Show all", position++));
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
        this.actions.get(key).execute(this.input, this.output, this.tracker);
    }

    private class AddItem extends BaseAction {

        AddItem(String name, int key) {
            super(name, key);
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
            ArrayList<String> forcomments = new ArrayList<String>();
            String end;
            do {
                forcomments.add(input.ask("Input item's comment "));
                end = input.ask("Is it all? (y/n) ");
            } while (end.equals("n"));
            item.setComments(forcomments);
            item = tracker.add(item);


        }


    }

    private static class FindItemById extends BaseAction {


        /**
         * Конструктор.
         *
         * @param name - имя события
         * @param key  - номер пункта меню
         */
        FindItemById(String name, int key) {
            super(name, key);
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

    }


}

class EditItem extends BaseAction {


    /**
     * Конструктор.
     *
     * @param name - имя события
     * @param key  - номер пункта меню
     */
    EditItem(String name, int key) {
        super(name, key);
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
            ArrayList<String> forcomments = new ArrayList<String>();

            String end;
            do {
                forcomments.add(input.ask("Input item's new comment "));
                end = input.ask("Is it all? (y/n) ");
            } while (end.equals("n"));
            item.setComments(forcomments);
            tracker.update(item);
        }
    }


}

class DeleteItem extends BaseAction {

    /**
     * Конструктор.
     *
     * @param name - имя события
     * @param key  - номер пункта меню
     */
    DeleteItem(String name, int key) {
        super(name, key);
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

}

class FindByName extends BaseAction {
    /**
     * Конструктор.
     *
     * @param name - имя события
     * @param key  - номер пункта меню
     */
    FindByName(String name, int key) {
        super(name, key);
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


}

class ShowAll extends BaseAction {
    /**
     * Конструктор.
     *
     * @param name - имя события
     * @param key  - номер пункта меню
     */
    ShowAll(String name, int key) {
        super(name, key);
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


}


