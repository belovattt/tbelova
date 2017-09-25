package ru.job4j.bank;

public class AccountIsAbsentException extends RuntimeException{
    AccountIsAbsentException(String msg){
        super(msg);
    }
}
