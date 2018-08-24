package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    public int ask(String question, int maxvalue) {
        int value = -1;
        do {
            try {
                value = super.ask(question, maxvalue);
            } catch (MenuOutException moe) {
                System.out.println("Please enter number between 0 and " + maxvalue);
            }
            catch (NumberFormatException nfe) {
                System.out.println("Please enter correct data");
            }
        } while (value == -1);
        return value;
    }
}
