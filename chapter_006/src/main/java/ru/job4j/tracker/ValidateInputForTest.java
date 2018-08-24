package ru.job4j.tracker;

public class ValidateInputForTest extends StubInput {
    Output output = new StubOutput();
    public String[] getOutputWrite() {
        return this.output.getLines();
    }
    /**
     * конструктор.
     *
     * @param answers - массив ответов
     */
    public ValidateInputForTest(String[] answers) {
        super(answers);
    }

    public int ask(String question, int maxvalue) {
        int value = -1;
        do {
            try {
                value = super.ask(question, maxvalue);
            } catch (MenuOutException moe) {
                output.write("Please enter number between 0 and " + maxvalue);
            }
            catch (NumberFormatException nfe) {
                output.write("Please enter correct data");
            }
        } while (value == -1);
        return value;
    }
}
