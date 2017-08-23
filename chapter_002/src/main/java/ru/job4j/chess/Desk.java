package ru.job4j.chess;

public class Desk {
    /**
     *доска из 64 клеток.
     */
    private Cell[][] chessdesk = new Cell[8][8];
    /**
     *конструктор, расставляем фигуры перед игрой.
     */
    public Desk() {
        int col = 1;
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
              chessdesk[i][j] = new Cell(col, i, j);
              col = - col;
          }
          col = - col;
        }
        for (int j = 0; j < 8; j++) {
            chessdesk[0][j].setFigure(new Elephant(1));
            chessdesk[1][j].setFigure(new Elephant(1));
            chessdesk[6][j].setFigure(new Elephant(-1));
            chessdesk[7][j].setFigure(new Elephant(-1));
        }
    }
    /**
     *метод возвращает доску с фигурами.
     *@return chessdesk
     */
    public Cell[][] getChessdesk() {
        return chessdesk;
    }
}
