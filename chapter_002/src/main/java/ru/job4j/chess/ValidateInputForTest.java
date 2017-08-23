package ru.job4j.chess;

import ru.job4j.module2.Output;
import ru.job4j.module2.StubOutput;
/**
 * Class ValidateInputForTest.
 * Используется в тестах, когда при вводе данных выбрасывается исключение
 *
 */

    public class ValidateInputForTest extends StubInput {
    /**
     * вывод в массив строк.
     */
        Output output = new StubOutput();
    /**
     * метод возвращает вывод в виде массива строк
     * @return массив строк
     */
        @Override
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
        /**
         * метод задает пользователю вопрос и получает ответ - 4 числа в диапазоне от 0 до 7.
         *
         *
         * @return - ответ
         */
        public int[] askMove() {
            int[] move = new int[4];
            boolean f = true;
            do {
                try {
                    move = super.askMove();
                    f = false;
                } catch (CellIsWrongException ciwe) {
                    output.write("Please enter number between 0 and 7");
                }
                catch (NumberFormatException nfe) {
                    output.write("Please enter correct data");
                }
            } while (f);
            return move;
        }
    }

