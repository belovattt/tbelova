package ru.job4j.chess;

import java.util.Arrays;
/**
 * Class Elefant (слон) расширяет класс Figure.
 *
 * @author Tatyana Belova
 * @since 21.08.2017
 */

public class Elephant extends Figure {
    /**
     * конструктор.
     *
     * @param color - цвет фигуры
     *
     */
    public Elephant(int color) {
        super();
        this.color = color;
    }

    /**
     * метод проверяет корректность пути, зависит от фигуры.
     *
     * @param cellFrom - откуда
     * @param cellTo - куда
     * @return true если путь корректный
     */
    @Override
    boolean validateMove(Cell cellFrom, Cell cellTo) {
        if (Math.abs(cellFrom.getX() - cellTo.getX()) != Math.abs(cellFrom.getY() - cellTo.getY())) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * метод возвращает путь, если путь корректный, или выбрасывает исключение.
     *
     * @param cellFrom - откуда
     * @param cellTo - куда
     * @return путь - массив клеток
     */
    @Override
    Cell[] move(Cell cellFrom, Cell cellTo, Desk desk) throws ImpossibleMoveException, WrongWayException {
        Cell[] way = new Cell[8];
        if (!((this.validateCellFrom(cellFrom)) && (this.validateCellTo(cellTo)))) {
            throw new ImpossibleMoveException();
        }
        if (! this.validateMove(cellFrom, cellTo)) {
            throw new WrongWayException();
        }
        int y = cellFrom.getY();
        int k = 0;
        for (int x = cellFrom.getX(); x != cellTo.getX(); x += (cellTo.getX() - cellFrom.getX())/Math.abs(cellFrom.getX() - cellTo.getX())) {
          if ((x !=cellFrom.getX()) && (x != cellTo.getX()) && (! desk.getChessdesk()[x][y].isFree())) {
              throw new WrongWayException();
          }
          way[k] = desk.getChessdesk()[x][y];
          y += (cellTo.getY() - cellFrom.getY())/Math.abs(cellFrom.getY() - cellTo.getY());
          k++;
        }
        way[k] = desk.getChessdesk()[cellTo.getX()][cellTo.getY()];
        k++;
        way = Arrays.copyOf(way, k);
        desk.getChessdesk()[cellTo.getX()][cellTo.getY()].setFree(false);
        desk.getChessdesk()[cellTo.getX()][cellTo.getY()].setFigure(desk.getChessdesk()[cellFrom.getX()][cellFrom.getY()].getFigure());
        desk.getChessdesk()[cellFrom.getX()][cellFrom.getY()].setFree(true);
        desk.getChessdesk()[cellFrom.getX()][cellFrom.getY()].setFigure(null);

        return way;
    }
}
