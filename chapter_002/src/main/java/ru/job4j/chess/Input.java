package ru.job4j.chess;
/**
 * Interface Input.
 *
 * @author Tatyana Belova
 * @since 21.08.2017
 */

public interface Input {
    /**
     * метод задает пользователю вопрос, окончена ли игра, и получает ответ.
     *
     * @return - ответ
     */
    String askQuit();
    /**
     * метод предлагает пользователю сделать ход получает ответ.
     *
     *
     * @return - ответ
     */
    int[] askMove();
   default String[] getOutputWrite() {
        return null;
    }


}
