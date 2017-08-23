package ru.job4j.chess;

public class CellIsWrongException extends RuntimeException {
    public CellIsWrongException() {
        super();
        System.out.println("The cell is wrong");
    }
}
