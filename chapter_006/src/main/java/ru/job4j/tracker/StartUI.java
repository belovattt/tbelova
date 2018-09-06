package ru.job4j.tracker;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * Class StartUI.
 *
 * @author Tatyana Belova
 * @since 24.08.2018
 */
public class StartUI {

    /**
     * ввод данных.
     */
    private Input input;

    /**
     * вывод данных.
     */
    private Output output;

    /**
     * tracker.
     */
    private Tracker tracker;

    /**
     * конструктор.
     *
     * @param input   - ввод данных
     * @param output  - вывод данных
     * @param tracker - tracker
     */
    public StartUI(Input input, Output output, Tracker tracker) {
        this.input = input;
        this.output = output;
        this.tracker = tracker;
    }

    /**
     * метод init.
     */
    public void init() {
        int choice;
        MenuTracker menu = new MenuTracker(input, output, tracker);
        menu.fillActions();
        do {
            menu.showMenu();
            menu.select(this.input.ask("Select:", menu.getMaxvalue()));
        } while (!"y".equals(this.input.ask("Exit? (y)")));
        tracker.close();
    }

    /**
     * метод main.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Output output = new ConsoleOutput();
        try (Tracker tracker = new Tracker()){

            new StartUI(input, output, tracker).init();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
