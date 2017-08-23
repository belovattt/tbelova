package ru.job4j.chess;

import java.util.Scanner;
import ru.job4j.module2.Output;
import ru.job4j.module2.StubOutput;
import ru.job4j.module2.ConsoleOutput;
/**
 * Class Chess решение задачи chess.
 *
 * @author Tatyana Belova
 * @since 21.08.2017
 */

public class Chess {
    /**
     * шахматная доска
     */
    private Desk desk;
    /**
     * input
     */
    private Input input;
    /**
     * output
     */
    private Output output;
    /**
     * конструктор.
     *
     * @param desk  - шахматная доска
     * @param input - ввод
     * @param output - вывод
     */
    public Chess(Desk desk, Input input, Output output) {
        this.desk = desk;
        this.input = input;
        this.output = output;
    }
    /**
     * сеанс игры в шахматы.
     */
    public void play() {
        String gameover = "n";
        do {
          int[] move = input.askMove();
          try {
              if (desk.getChessdesk()[move[0]][move[1]].isFree()) {
                  throw new FigureIsMissing();
              }
              Cell[] cells = desk.getChessdesk()[move[0]][move[1]].getFigure().move(desk.getChessdesk()[move[0]][move[1]], desk.getChessdesk()[move[2]][move[3]], desk);
              System.out.println("Figure's move:");
              for (Cell cell : cells) {
                  output.write(cell.getX() + " " + cell.getY());
              }
          } catch (FigureIsMissing fim) {
              output.write("The first cell is empty");
          }
          catch (ImpossibleMoveException ime) {
              output.write("The second cell is busy");
          }
          catch (WrongWayException wwe) {
              output.write("This way is wrong");
          }
          gameover = input.askQuit();
      } while (!gameover.equals("y"));
    }
    /**
     * метод запускает игру.
     * @param args - args
     */
    public static void main(String[] args) {
        Desk desk = new Desk();
       Input input = new ValidateInput();
       Output output = new ConsoleOutput();
       new Chess(desk, input, output).play();
    }
}
