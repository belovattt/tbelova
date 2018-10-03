package ru.job4j.tracker;

import java.util.Scanner;

/**
 * class ValidateInput.
 *@author Tatyana Belova
 *@since 5.08.2017
 */
public class ValidateInput implements Input {
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
    public final String ask(final String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * метод задает пользователю вопрос.
     * и получает ответ - число в диапазоне
     * от 0 до maxvalue.
     *
     * @param question - вопрос
     * @param maxvalue - maxvalue
     * @return key - ответ
     */
    private int asking(final String question, final int maxvalue) {
        int key = -1;
        key = Integer.parseInt(this.ask(question));
        if (key > maxvalue) {
            key = -1;
        }
        if (key == -1) {
            throw new MenuOutException("Out of range");
        }
        return key;
    }

    /**
     * output.
     * @return string
     */
    @Override
    public final String[] getOutputWrite() {
        return new String[0];
    }

@Override
    public final int ask(final String question, final int maxvalue) {
        int value = -1;
        do {
            try {
                value = asking(question, maxvalue);
            } catch (MenuOutException moe) {
                System.out.println("Please enter number between 0 and "
                        + maxvalue);
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter correct data");
            }
        } while (value == -1);
        return value;
    }
}
