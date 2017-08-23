package ru.job4j.chess;

public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException() {
        super();
        System.out.println("This move is impossible");
    }
}
