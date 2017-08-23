package ru.job4j.chess;

public class FigureIsMissing extends RuntimeException {
    public FigureIsMissing() {
        System.out.println("This cell is empty");
    }
}
