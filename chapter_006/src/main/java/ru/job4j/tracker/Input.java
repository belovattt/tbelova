package ru.job4j.tracker;

/**
 * Interface Input решение задачи второго модуля.
 *
 * @author Tatyana Belova
 * @since 28.07.2017
 */
public interface Input {
   /**
     * метод задает пользователю вопрос и получает ответ.
     *
     * @param question - вопрос
     * @return - ответ
     */
    default String ask(String question) {
     return null;
    };

    /**
     * метод задает пользователю вопрос.
     * и получает ответ -
     * число в диапазоне от 0 до maxvalue.
     *
     * @param question - вопрос
     * @param maxvalue - maxvalue
     * @return - ответ
     */
    int ask(String question, int maxvalue);

    /**
     * метод зачем-то был нужен.
     * но это было давно
     * @return String[]
     */
    String[] getOutputWrite();
}
