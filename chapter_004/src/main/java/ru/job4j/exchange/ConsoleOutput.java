package ru.job4j.exchange;

/**
 * Вывод результатов в консоль.
 */
public class ConsoleOutput {
    /**
     * метод выводит в консоль содержимое setOfBooks.
     *
     * @param setOfBooks - setOfBooks
     */
    public static void printInConsole(SetOfBooks setOfBooks) {
        System.out.println(stringOfSetOfBooks(setOfBooks));

    }

    /**
     * метод возвращает содержимое setOfBooks в виде строки.
     * заявки с одинаковой ценой объединяются
     *
     * @param setOfBooks
     * @return
     */
    public static StringBuffer stringOfSetOfBooks(SetOfBooks setOfBooks) {
        StringBuffer result = new StringBuffer();
        for (Integer key : setOfBooks.getSetOfBooks().keySet()) {
            OrderBook orderBook = setOfBooks.getSetOfBooks().get(key);
            result.append("book number " + key + "\n");
            result.append(orderBook.stringOutput());
        }
        return result;
    }
}
