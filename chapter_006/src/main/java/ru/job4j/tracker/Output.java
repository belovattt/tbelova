package ru.job4j.tracker;
/**
 *Interface Output решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 1.08.2017
*/
public interface Output {
    /**
     * метод выводит строку line.
     * @param line - line
     */
    void write(String line);
    /**
     * метод возвращает массив со строками.
     * @return массив
     */
    String[] getLines();
}
