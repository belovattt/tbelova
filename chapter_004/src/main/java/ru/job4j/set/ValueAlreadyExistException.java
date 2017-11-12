package ru.job4j.set;

public class ValueAlreadyExistException extends RuntimeException {
    ValueAlreadyExistException(String message) {
        super(message);
    }
}
