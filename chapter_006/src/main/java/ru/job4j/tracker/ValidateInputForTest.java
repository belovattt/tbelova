package ru.job4j.tracker;

/**
 * class ValidateInputForTest.
 */
public class ValidateInputForTest implements Input {
    /**
     * массив ответов.
     */
    private String[] answers;
    /**
     * индекс текущего элемента массива.
     */
    private int position = 0;
    /**
     * output.
     */
    private Output output = new StubOutput();

    /**
     * метод для вывода строки.
     * @return строка
     */
    public final String[] getOutputWrite() {
        return this.output.getLines();
    }
    /**
     * конструктор.
     *
     * @param answers - массив ответов
     */
    public ValidateInputForTest(final String[] answers) {
        this.answers = answers;
    }
@Override
    public final int ask(final String question, final int maxvalue) {
        int value = -1;
        do {
            try {
                value = asking(question, maxvalue);
            } catch (MenuOutException moe) {
                output.write("Please enter number between 0 and " + maxvalue);
            } catch (NumberFormatException nfe) {
                output.write("Please enter correct data");
            }
        } while (value == -1);
        return value;
    }
    /**
     * метод задает пользователю вопрос.
     * и получает ответ - число в диапазоне от 0 до maxvalue.
     *
     * @param question - вопрос
     * @param maxvalue - maxvalue
     * @return - ответ
     */
    private int asking(final String question, final int maxvalue) {
        int key = -1;
        key = Integer.parseInt(this.answers[this.position++]);
        if (key > maxvalue) {
            key = -1;
        }
        if (key == -1) {
            throw new MenuOutException("Out of range");
        }
        return key;

    }

}
