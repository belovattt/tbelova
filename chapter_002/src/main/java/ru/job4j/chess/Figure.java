package ru.job4j.chess;
/**
 * Class Figure реализует методы, общие для всех фигур.
 * Содержит два абстрактных метода, реализация которых зависит от фигуры.
 * @author Tatyana Belova
 * @since 21.08.2017
 */

public abstract class Figure {
    /**
     *цвет фигуры.
     */
    protected int color;
    /**
     *метод возвращает цвет фигуры.
     *@return color
     */
    public int getColor() {
        return color;
    }
    /**
     *метод проверяет корректность конечной ячейки, не зависит от фигуры.
     *@return true если ячейка корректная
     */
    final boolean validateCellTo(Cell cellTo) {
        if (((!cellTo.isFree()) && (cellTo.getFigure().getColor() == this.getColor()))) {
            return false;
        } else return true;
    }
    /**
     *метод проверяет корректность начальной ячейки, не зависит от фигуры.
     *@return true если ячейка корректная
     */
    final boolean validateCellFrom(Cell cellFrom) {
        if ((cellFrom.isFree())) {
          return false;
        } else {
            return true;
        }
    }
    /**
     * метод проверяет корректность пути, зависит от фигуры.
     *
     * @param cellFrom - откуда
     * @param cellTo - куда
     * @return true если путь корректный
     */
    abstract boolean validateMove(Cell cellFrom, Cell cellTo);
    /**
     * метод возвращает путь, если путь корректный, или выбрасывает исключение.
     *
     * @param cellFrom - откуда
     * @param cellTo - куда
     * @return путь - массив клеток
     */
    abstract Cell[] move(Cell cellFrom, Cell cellTo, Desk desk) throws ImpossibleMoveException, WrongWayException;
}
