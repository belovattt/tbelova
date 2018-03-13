package ru.job4j.exchange;

/**
 * OrderBook - одна книга с двумя списками.
 * sellBook - продажа
 * buyBook - покупка
 */
public class OrderBook {

    /**
     * возвращает sellBook.
     *
     * @return sellBook
     */
    public OrderedList getSellBook() {
        return sellBook;
    }

    /**
     * метод записывает sellBook.
     *
     * @param sellBook - sellBook
     */
    public void setSellBook(OrderedList sellBook) {
        this.sellBook = sellBook;
    }

    /**
     * sellBook.
     */
    private OrderedList sellBook = new OrderedList();

    /**
     * метод возвращает buyBook.
     *
     * @return buyBook
     */
    public OrderedList getBuyBook() {
        return buyBook;
    }

    /**
     * метод записывает buyBook.
     *
     * @param buyBook - buyBook
     */
    public void setBuyBook(OrderedList buyBook) {
        this.buyBook = buyBook;
    }

    /**
     * buyBook
     */
    private OrderedList buyBook = new OrderedList();

    /**
     * метод возвращает содержимое книги в виде строки.
     *
     * @return buy...sell...
     */
    @Override
    public String toString() {
        return "buy" + this.buyBook.toString() + "sell" + this.sellBook.toString();
    }

    /**
     * Метод выводит содержимое книги в строку для вывода в консоль или в файл.
     */
    public StringBuffer stringOutput() {
        StringBuffer result = new StringBuffer();
        result.append("Продажа:\n");
        result.append(this.sellBook.stringOutput());
        result.append("Покупка:\n");
        result.append(this.buyBook.stringOutput());
        return result;
    }
}
