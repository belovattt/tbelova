package ru.job4j.tracker;
/**
 * Class BaseAction.
 *
 * @author Tatyana Belova
 * @since 28.07.2017
 */

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

    BaseAction(final String name, final int key) {
        this.name = name;
        this.key = key;
    }

    /**
     *выбор пункта меню.
     * @param key - номер пункта
     */
    public final void setKey(final int key) {
        this.key = key;
    };
    /**
     *номер текущего пункта меню.
     * @return key
     */
    public final int getKey() {
        return this.key;
    };


    /**
     * действие.
     *
     * @param input   - ввод
     * @param output  - вывод
     * @param tracker - tracker
     */

    @Override
    public void execute(
            final Input input, final Output output, final Tracker tracker) {
    }

    /**
     * вывод информации.
     * @return information
     */
    @Override
    public final String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}

