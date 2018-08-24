package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author Tatyana Belova
 * @since 28.07.2017
 */
public class ConsoleInput implements Input {
    /**
     * scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * метод задает пользователю вопрос и получает ответ.
     *
     * @param question - вопрос
     * @return scanner.nextLine - ответ
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * метод задает пользователю вопрос и получает ответ - число в диапазоне от 0 до maxvalue.
     *
     * @param question - вопрос
     * @param maxvalue - maxvalue
     * @return key - ответ
     */
    public int ask(String question, int maxvalue) {
        int key = -1;
        key = Integer.parseInt(this.ask(question));
        if (key > maxvalue) {
            key = -1;
        }
        if (key == -1) throw new MenuOutException("Out of range");
        return key;
    }

    @Override
    public String[] getOutputWrite() {
        return new String[0];
    }
}