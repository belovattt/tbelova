package ru.job4j.exchange;

import java.util.Scanner;

/**
 * класс Exchange.
 */
public class Exchange {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();
        new SetOfBooks(fileName).printInConsole();
    }
}
