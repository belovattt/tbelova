package ru.job4j.tracker;

/**
 *Interface UserAction.
 *@author Tatyana Belova
 *@since 5.08.2017
 */

public interface UserAction {
    /**
     *выбор пункта меню.
     * @param key - key
     */
    void setKey(int key);
    /**
     *номер текущего пункта меню.
     * @return key
     */
    int getKey();
    /**
     *действие.
     * @param input - ввод
     * @param output - вывод
     * @param tracker - tracker
     */
    void execute(Input input, Output output, Tracker tracker);
    /**
     *вывод информации.
     * @return information
     */
    String info();
}
