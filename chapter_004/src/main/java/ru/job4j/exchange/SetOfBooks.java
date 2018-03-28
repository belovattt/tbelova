package ru.job4j.exchange;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Класс для хранения книг заявок по номерам.
 */
public class SetOfBooks {


    /**
     * hashmap для книг заявок.
     */
    private HashMap<Integer, OrderBook> setOfBooks = new HashMap<>();

    /**
     * конструктор читает строки из файла и заполняет setOfBooks.
     *
     * @param fileName - имя файла
     */
    SetOfBooks(String fileName) {
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
                        this.add(bookNumber, orderType, order);
                    } else {
                        int bookNumber = numberOfBook(orderInString);
                        int orderId = idOfOrder(orderInString);
                        this.delete(bookNumber, orderId);
                    }

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    /**
     * конструктор для тестов.
     */
    SetOfBooks() {

    }

    /**
     * конструктор для тестов.
     */
    SetOfBooks(String[] orderArray) {
        for (int i = 0; i < orderArray.length; i++) {
            String orderInString = orderArray[i];
            if (orderInString.contains("book")) {
                if (orderInString.contains("A")) {
                    int bookNumber = numberOfBook(orderInString);
                    String orderType = typeOfOrder(orderInString);
                    Order order = orderFromString(orderInString);
                    this.add(bookNumber, orderType, order);
                } else {
                    int bookNumber = numberOfBook(orderInString);
                    int orderId = idOfOrder(orderInString);
                    this.delete(bookNumber, orderId);
                }

            }
        }


    }

    /**
     * метод добавляет заявку.
     *
     * @param bookNumber - номер книги
     * @param orderType  - покупка или продажа
     * @param order      - заявка
     */
    public void add(Integer bookNumber, String orderType, Order order) {
        if (!setOfBooks.containsKey(bookNumber)) {
            OrderBook orderBook = new OrderBook();
            this.setOfBooks.put(bookNumber, orderBook);
        }
        OrderBook orderBook = setOfBooks.get(bookNumber);

        if (orderType.equals("sell")) {
            order = orderBook.getBuyBook().checkSellOrder(order);
            if (order.getVolume() != 0) {
                if (orderBook.getSellBook().containsKey(order.getPrice())) {
                    SamePrice samePrice = orderBook.getSellBook().get(order.getPrice());
                    samePrice.put(order.getId(), order);
                    orderBook.getSellBook().put(order.getPrice(), samePrice);
                } else {
                    SamePrice samePrice = new SamePrice();
                    samePrice.put(order.getId(), order);
                    orderBook.getSellBook().put(order.getPrice(), samePrice);
                }
            }
        } else {
            order = orderBook.getSellBook().checkBuyOrder(order);
            if (order.getVolume() != 0) {
               if (orderBook.getBuyBook().containsKey(order.getPrice())) {
                   SamePrice samePrice = orderBook.getBuyBook().get(order.getPrice());
                   samePrice.put(order.getId(), order);
                   orderBook.getBuyBook().put(order.getPrice(), samePrice);
               } else {
                   SamePrice samePrice = new SamePrice();
                   samePrice.put(order.getId(), order);
                   orderBook.getBuyBook().put(order.getPrice(), samePrice);
               }
            }
        }
        setOfBooks.put(bookNumber, orderBook);

    }

    /**
     * метод удаляет заявку из указанной книги по указанному id
     *
     * @param booknumber - номер книги
     * @param orderId    - id
     * @return true, если заявка удалена
     */
    public boolean delete(Integer booknumber, int orderId) {
        boolean result = false;
        if (setOfBooks.containsKey(booknumber)) {
            OrderBook orderBook = setOfBooks.get(booknumber);
            if (orderBook.getBuyBook().deleteOrderOnId(orderId)) {
                result = true;
            }
            if ((!result) && (orderBook.getSellBook().deleteOrderOnId(orderId))) {
                result = true;
            }
        }
        return result;
    }

    /**
     * метод возвращает содержимле всех книг с заявками в виде строки.
     *
     * @return номер_книги sell...buy...
     */
    @Override
    public String toString() {
        String s = "";
        for (Integer key : setOfBooks.keySet()) {
            s = s + key + setOfBooks.get(key).toString() + " ";
        }
        return s;
    }

    /**
     * метод выводит в консоль содержимое setOfBooks.
     */
    public void printInConsole() {
        System.out.println(this.stringOfSetOfBooks());

    }

    /**
     * метод возвращает содержимое setOfBooks в виде строки.
     * заявки с одинаковой ценой объединяются
     *
     * @return
     */
    public StringBuffer stringOfSetOfBooks() {
        StringBuffer result = new StringBuffer();
        for (Integer key : this.setOfBooks.keySet()) {
            OrderBook orderBook = this.setOfBooks.get(key);
            result.append("book number " + key + "\n");
            result.append(orderBook.stringOutput());
        }
        return result;
    }

    /**
     * метод возвращает номер книги.
     *
     * @param s - строка
     * @return номер книги
     */
    private static int numberOfBook(String s) {
        return Integer.parseInt(s.substring(s.indexOf("-") + 1, s.indexOf(("\""), s.indexOf("-"))));
    }

    /**
     * метод возвращает тип заявки (продажа или покупка).
     *
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
     *
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
     *
     * @param s - строка
     * @return id
     */
    private static int idOfOrder(String s) {
        return Integer.parseInt(s.substring(s.indexOf("orderId") + 9, s.indexOf(("\""), s.indexOf("orderId") + 9)));
    }

}
