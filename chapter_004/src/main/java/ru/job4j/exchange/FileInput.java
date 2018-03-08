package ru.job4j.exchange;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * статические методы для заполнения списка заявок из файла.
 */
public class FileInput {
    /**
     * метод возвращает номер книги.
     * @param s - строка
     * @return номер книги
     */
    private static int numberOfBook (String s) {
        return Integer.parseInt(s.substring(s.indexOf("-") + 1, s.indexOf(("\""), s.indexOf("-"))));
    }

    /**
     * метод возвращает тип заявки (продажа или покупка).
     * @param s - строка
     * @return buy или sell
     */
    private static String typeOfOrder(String s) {
        String result = "buy";
        if (s.contains("S")) {
            result = "sell";
        }
        return result;
    }

    /**
     * метод возвращает заявку.
     * @param s строка
     * @return order
     */
    private static Order orderFromString(String s) {
        double price = Double.parseDouble(s.substring(s.indexOf("price") + 7, s.indexOf(("\""), s.indexOf("price") + 7)));
        int volume = Integer.parseInt(s.substring(s.indexOf("volume") + 8, s.indexOf(("\""), s.indexOf("volume") + 8)));
        int id = Integer.parseInt(s.substring(s.indexOf("orderId") + 9, s.indexOf(("\""), s.indexOf("orderId") + 9)));
        return new Order(id, price, volume);
    }

    /**
     * метод возвращает id заявки.
     * @param s - строка
     * @return id
     */
    private static int idOfOrder(String s) {
        return Integer.parseInt(s.substring(s.indexOf("orderId") + 9, s.indexOf(("\""), s.indexOf("orderId") + 9)));
    }

    /**
     * метод читает строки из файла возвращает списки всех заявок, разделенные по книгам.
     * @param fileName - имя файла
     * @return setOfBooks
     */
    public static SetOfBooks downloadBooks(String fileName) {
    SetOfBooks setOfBooks = new SetOfBooks();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String orderInString = scanner.nextLine();
                if (orderInString.contains("book")) {
                    if (orderInString.contains("A")) {
                        int bookNumber = numberOfBook(orderInString);
                        String orderType = typeOfOrder(orderInString);
                        Order order = orderFromString(orderInString);
                        setOfBooks.add(bookNumber, orderType, order);
                    } else {
                        int bookNumber = numberOfBook(orderInString);
                        int orderId = idOfOrder(orderInString);
                        setOfBooks.delete(bookNumber, orderId);
                    }

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return setOfBooks;
    }

}
