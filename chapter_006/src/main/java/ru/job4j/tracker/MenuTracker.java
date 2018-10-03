package ru.job4j.tracker;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Class MenuTracker реализует меню.
 *
 * @author Tatyana Belova
 * @since 24.08.2018
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
     * menuMax.
     */
    private final int menuMax = 6;

    /**
     * массив действий пользователя.
     */
    private ArrayList<UserAction> actions = new ArrayList<>(menuMax);

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
    public final int getMaxvalue() {
        return this.actions.size() - 1;
    }

    /**
     * конструктор.
     *
     * @param input   - ввод данных
     * @param tracker - tracker
     * @param output - output
     */
    public MenuTracker(final Input input, final Output output,
                       final Tracker tracker) {
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
    /*
    public final void init(final Input input, final Output output,
    final Tracker tracker) {


    }
    */


    /**
     * заполнение массива actions.
     */
    public final void fillActions() {
        this.actions.add(this.new AddItem("Add item", position++));
        this.actions.add(
                new MenuTracker.FindItemById("Find item by id", position++));
        this.actions.add(new EditItem("Edit item", position++));
        this.actions.add(new DeleteItem("Delete item", position++));
        this.actions.add(new FindByName("Find item by name", position++));
        this.actions.add(new ShowAll("Show all", position++));
    }

    /**
     * вывод меню на экран.
     */
    public final void showMenu() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * выбор пользователя.
     * @param key - key
     */
    public final void select(final int key) {
        this.actions.get(key).execute(this.input, this.output, this.tracker);
    }

    /**
     * класс AddItem.
     */
    private class AddItem extends BaseAction {
        /**
         * констркетор.
         * @param name - name
         * @param key - key
         */

        AddItem(final String name, final int key) {
            super(name, key);
        }

        /**
         * действие.
         *
         * @param input   - ввод
         * @param tracker - tracker
         */
        @Override
        public final void execute(final Input input, final Output output,
                                  final Tracker tracker) {
            Item item = new Item();
            item.setName(input.ask("Input item's name "));
            item.setDescription(input.ask("Input item's description "));
            item.setCreated(Date.valueOf(LocalDate.now()));
            StringBuffer forcomments = new StringBuffer();
            String end;
            do {
                forcomments.append(input.ask("Input item's comment ") + "\n");
                end = input.ask("Is it all? (y/n) ");
            } while (end.equals("n"));
            item.setComments(forcomments.toString());
            try {
                tracker.add(item);
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


    }

    /**
     * класс FindItemById.
     */
    private static class FindItemById extends BaseAction {


        /**
         * Конструктор.
         *
         * @param name - имя события
         * @param key  - номер пункта меню
         */
        FindItemById(final String name, final int key) {
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
        public final void execute(final Input input, final Output output,
                                  final Tracker tracker) {
            Item item = null;
            try {
                item = tracker.findById(Integer.parseInt(
                        input.ask("Enter item's id")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (item == null) {
                output.write("Item not found");
            } else {
                output.write(item.getName());
                output.write(item.getDescription());
                output.write(item.getCreated().toString());
                output.write(item.getComments());

            }

        }

    }


}

/**
 * класс EditItem.
 */
class EditItem extends BaseAction {


    /**
     * Конструктор.
     *
     * @param name - имя события
     * @param key  - номер пункта меню
     */
    EditItem(final String name, final int key) {
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
    public final void execute(final Input input,
                              final Output output, final Tracker tracker) {
        Item item = new Item();
        item.setId(Integer.parseInt(input.ask("Please, enter item's id ")));

        item.setName(input.ask("Input item's new name "));
        item.setDescription(input.ask("Input item's new description "));
        StringBuffer forcomments = new StringBuffer();
        String end;
        do {
            forcomments.append(input.ask("Input item's new comment ") + "/n");
            end = input.ask("Is it all? (y/n) ");
        } while (end.equals("n"));
        item.setComments(forcomments.toString());
        try {
            tracker.update(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/**
 * клосс DeleteItem.
 */

class DeleteItem extends BaseAction {

    /**
     * Конструктор.
     *
     * @param name - имя события
     * @param key  - номер пункта меню
     */
    DeleteItem(final String name, final int key) {
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
    public final void execute(final Input input,
                              final Output output, final Tracker tracker) {

        int id = Integer.parseInt(input.ask("Please, enter item's id "));
        try {
            tracker.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

/**
 * класс FindByName.
 */
    class FindByName extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name - имя события
         * @param key  - номер пункта меню
         */
        FindByName(final String name, final int key) {
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
        public final void execute(final Input input,
                                  final Output output, final Tracker tracker) {
            String name = input.ask("Please, enter item's name");
            ArrayList<Item> finder = new ArrayList<>();
            try {
                finder = tracker.findByName(name);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Item item : finder) {
                output.write("Item's name " + item.getName());
                output.write("Item's description " + item.getDescription());
                output.write("Item was created " + item.getCreated());
                output.write("Item's id " + item.getId());
                output.write("Item's comments:");
                output.write(item.getComments());

            }
        }


    }

/**
 * класс ShowAll.
 */
    class ShowAll extends BaseAction {
        /**
         * Конструктор.
         *
         * @param name - имя события
         * @param key  - номер пункта меню
         */
        ShowAll(final String name, final int key) {
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
        public final void execute(final Input input,
                                  final Output output, final Tracker tracker) {
            ArrayList<Item> finder = new ArrayList<>();
            try {
                finder = tracker.getAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            for (Item item : finder) {
                output.write("Item's name " + item.getName());
                output.write("Item's description " + item.getDescription());
                output.write("Item was created " + item.getCreated());
                output.write("Item's id " + item.getId());
                output.write("Item's comments:");
                output.write(item.getComments());

            }
        }
    }



