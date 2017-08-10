package ru.job4j.module2;

/**
 * Class StubInput решение задачи второго модуля.
 *
 * @author Tatyana Belova
 * @since 30.07.2017
 */
public class StubInput implements Input {
    /**
     * массив ответов.
     */
    private String[] answers;
    /**
     * индекс текущего элемента массива.
     */
    private int position = 0;

    /**
     * конструктор.
     *
     * @param answers - массив ответов
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * метод эмулирует ответ пользователя.
     *
     * @param question - вопрос
     * @return answers[position++] - ответ
     */
    public String ask(String question) {

        return this.answers[this.position++];
    }

    /**
     * метод задает пользователю вопрос и получает ответ - число в диапазоне от 0 до maxvalue.
     *
     * @param question - вопрос
     * @param maxvalue - maxvalue
     * @return - ответ
     */
    public int ask(String question, int maxvalue) {
        int key = -1;
        key = Integer.parseInt(this.answers[this.position++]);
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

    public String[] getOutputwrite() {
        return null;
    }
}