package ru.job4j.chess;
/**
 * Class ValidateInput вводит данные и проверяет корректность ввода.
 *
 * @author Tatyana Belova
 * @since 21.08.2017
 */

public class ValidateInput extends ConsoleInput {
    /**
     * метод предлагает пользователю ввести 4 числа от 0 до 7.
     * и проверяет корректность ввода.
     * @return ход
     */
    public int[] askMove() {
        boolean f = true;
        int[] move = new int[4];
        do {
            try {
                move = super.askMove();
                f = false;
            } catch (CellIsWrongException ciwe) {
                System.out.println("Please enter number between 0 and 7");
            }
            catch (NumberFormatException nfe) {
                System.out.println("Please enter correct data");
            }
        } while (f);
        return move;
    }
}
