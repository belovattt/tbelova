package ru.job4j.module2;

public abstract class BaseAction implements UserAction {
    /**
     * имя события.
     */
    private String name;
    /**
     * пункт меню.
     */
    private int key;
    /**
     * Конструктор.
     * @param name - имя события
     * @param key - номер пункта меню
     */

    BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }

    /**
     *выбор пункта меню.
     */
    public void setKey(int key) {
        this.key = key;
    };
    /**
     *номер текущего пункта меню.
     */
    public int getKey() {
        return this.key;
    };


    /**
     * действие.
     *
     * @param input   - ввод
     * @param output  - вывод
     * @param tracker - tracker
     */
    @Override    public void execute(Input input, Output output, Tracker tracker) {

    }

    /**
     * вывод информации .
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
