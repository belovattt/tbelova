package ru.job4j.chess;

public class WrongWayException extends RuntimeException {
    public WrongWayException() {
        super();
        System.out.println("This way is wrong");
    }
}
