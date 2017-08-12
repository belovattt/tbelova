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
    void setKey(int key);
    /**
     *номер текущего пункта меню.
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
     *вывод информации .
     */
    String info();
}
