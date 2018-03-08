package ru.job4j.exchange;

import java.util.HashMap;

/**
 * Класс для хранения книг заявок по номерам.
 */
public class SetOfBooks {
    /**
     * возвращает hashmap, где хранятся книги заявок.
     * @return setOfBooks
     */
    public HashMap<Integer, OrderBook> getSetOfBooks() {
        return setOfBooks;
    }

    /**
     * hashmap для книг заявок.
     */
    private HashMap<Integer, OrderBook> setOfBooks = new HashMap<>();

    /**
     * метод добавляет заявку.
     * @param bookNumber - номер книги
     * @param orderType - покупка или продажа
     * @param order - заявка
     */
    public void add(Integer bookNumber, String orderType, Order order) {
        if (!setOfBooks.containsKey(bookNumber)) {
            OrderBook orderBook = new OrderBook();
            this.setOfBooks.put(bookNumber, orderBook);
        }
        OrderBook orderBook = setOfBooks.get(bookNumber);

        if (orderType.equals("sell")) {
            orderBook.getBuyBook().checkSellOrder(order);
            if (order.getVolume() != 0) {
                orderBook.getSellBook().add(order);
            }
        } else {
            orderBook.getSellBook().checkBuyOrder(order);
            if (order.getVolume() != 0) {
                orderBook.getBuyBook().add(order);
            }
        }
        setOfBooks.put(bookNumber, orderBook);

    }

    /**
     * метод удаляет заявку из указанной книги по указанному id
     * @param booknumber - номер книги
     * @param orderId - id
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


}
