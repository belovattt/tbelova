package ru.job4j.module2;
/**
 *Interface UserAction.
 *@author Tatyana Belova
 *@since 5.08.2017
 */
public interface UserAction {
    /**
     *выбор пункта меню.
     */
    int key();
    /**
     *действие.
     * @param input - ввод
     * @param output - вывод
     * @param tracker - tracker
     */
    void execute(Input input, Output output, Tracker tracker);
    /**
     *вывод информации .
     */
    String info();
}
