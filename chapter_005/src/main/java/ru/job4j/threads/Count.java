package ru.job4j.threads;

import java.util.Scanner;

/**
 * Класс Count.
 */
public class Count {
    /**
     * метод вводит из консоли имя файла для подсчета количества символов.
     * и запускает отдельный поток для подсчета
     * если поток работает дольше 1000 мс,
     * метод вызывает его прерывание
     * @param args
     **/
    public static void main(String[] args) {
    Scanner consoleScanner = new Scanner(System.in);
    System.out.println("Введите имя файла");
    String filename = consoleScanner.nextLine();
    Thread countChar = new Thread(new CountChar(filename));
    countChar.start();
    try {
        countChar.join(1000);
    } catch (InterruptedException e) {

    }
    if (countChar.isAlive()) countChar.interrupt();
}
}
