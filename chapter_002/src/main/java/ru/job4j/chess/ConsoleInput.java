package ru.job4j.chess;


import java.util.Scanner;
/**
 * Class ConsoleInput решение задачи chess.
 *
 * @author Tatyana Belova
 * @since 22.08.2017
 */


    public class ConsoleInput implements Input {
        /**
         * scanner.
         */
        private Scanner scanner = new Scanner(System.in);

        /**
         * метод задает пользователю вопрос и получает ответ.
         *
         * @return scanner.nextLine - ответ
         */
        public String askQuit() {
            System.out.print("Do you want to finish game?(y/n): ");
            return scanner.nextLine();
        }

        /**
         * метод предлагает пользователю сделать ход и получает ответ - массив из четырех чисел от 0 до 7.
         *
         * @return массив из двух чисел
         */
        public int[] askMove() throws CellIsWrongException{
            int[] move = new int[4];
            System.out.println("Введите 4 числа через пробел: адрес исходной и конечной клетки");
            for (int i = 0; i < 4; i++) {
                move[i] = Integer.parseInt(scanner.next());

                if ((move[i] < 0) || (move[i] > 7)) {
                    throw new CellIsWrongException();
                }
            }
            String s = scanner.nextLine();
            return move;
        }
}
