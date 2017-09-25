package ru.job4j.bank;

public class UserIsAbsentException extends RuntimeException {
    UserIsAbsentException(String msg) {
        super(msg);
    }
}
