package ru.job4j.chess;

public class Cell {
    /**
     *цвет клетки -1 - черная, 1 - белая.
     */
    private int color;
    /**
     *свободная или нет.
     */
    private boolean free;
    /**
     *координата х.
     */
    private final int x;
    /**
     *координата y.
     */
    private final int y;
    /**
     *фигура в этой ячейке.
     */
    private Figure figure;
    /**
     *конструктор.
     * @param color - color
     * @param x
     * @param y
     */
    public Cell(int color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        if ((x > 1) && (x < 6)) {
            this.free = true;
        } else {
            this.free = false;
        }
    }
    /**
     *метод возвращает координату х.
     *@return х
     */
    public int getX() {
        return x;
    }
    /**
     *метод возвращает координату y.
     *@return y
     */
    public int getY() {
        return y;
    }

    /**
     *метод возвращает цвет.
     *@return color
     */
    public int getColor() {
        return color;
    }
    /**
     *метод устанавливает цвет.
     */
    public void setColor(int color) {
        this.color = color;
    }
    /**
     *метод проверяет, свободна ли ячейка.
     *@return free
     */
    public boolean isFree() {
        return free;
    }
    /**
     *метод изменяет статус ячейки.
     */
    public void setFree(boolean free) {
        this.free = free;
    }
    /**
     *метод возвращает фигуру в ячейке.
     *@return figure
     */
     public Figure getFigure() {
         return figure;
     }
    /**
     *метод устанавливает фигуру в ячейку.
     * @param figure - фигура
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }
}
