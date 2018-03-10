package ru.job4j.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * класс реализует метод для подсчета количества символов в файле.
 */
public class CountChar implements Runnable {
    /**
     * имя файла.
     */
    private String filename;

    /**
     * конструктор.
     * @param filename - имя файла
     */
    CountChar(String filename) {
        this.filename = filename;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        int count = 0;
        try {
            File file = new File(this.filename);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String s = fileScanner.nextLine();
                count += s.length();
                if (Thread.interrupted()) {
                    System.out.println("Выполнение программы прервано");
                    return;
                }
            }
            System.out.println("Количество символов в тексте" + count);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }
}
