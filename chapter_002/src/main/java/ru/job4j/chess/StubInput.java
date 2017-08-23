package ru.job4j.chess;
/**
 * Class StubInput - имитация ввода данных для тестов.
 *
 * @author Tatyana Belova
 * @since 21.08.2017
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

        @Override
        public String askQuit() {
            return this.answers[this.position++];
        }

        /**
         * метод задает пользователю вопрос и получает ответ - 4 числа в диапазоне от 0 до 7.
         *
         *
         * @return - ответ
         */
        public int[] askMove() throws CellIsWrongException {
            int[] move = new int[4];

            for (int i = 0; i < 4; i++) {
                move[i] = Integer.parseInt(this.answers[position++]);

                if ((move[i] < 0) || (move[i] > 7)) {
                    throw new CellIsWrongException();
                }
            }

            return move;
        }




    }

