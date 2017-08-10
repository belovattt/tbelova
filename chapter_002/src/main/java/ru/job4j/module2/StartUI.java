package ru.job4j.module2;

import java.util.Arrays;

/**
 * Class StartUI решение задачи второго модуля.
 *
 * @author Tatyana Belova
 * @since 26.07.2017
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
    }

    /**
     * метод main.
     *
     * @param args - args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        new StartUI(input, output, tracker).init();
    }
}
