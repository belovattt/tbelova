package ru.job4j.exchange;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetOfBookTest {
    @Test
    /**
     * тесто проверяет метод добавления заявок в книгу.
     */
    public void addTest() {
        SetOfBooks setOfBooks = new SetOfBooks();
        setOfBooks.add(1, "sell", new Orderok(1, 7.5, 1));
        setOfBooks.add(1, "sell", new Orderok(2, 10.9, 2));
        setOfBooks.add(1, "buy", new Orderok(3, 7.7, 8));
        setOfBooks.add(1, "sell", new Orderok(4, 11, 2));
        setOfBooks.add(1, "buy", new Orderok(5, 10.9, 2));
        assertThat(setOfBooks.toString(), is("1buy 7.7 7 3sell 11.0 2 4 "));
    }

    @Test
    /**
     * тест проверяет метод удаления заявки из книги.
     */
    public void deleteTest() {
        SetOfBooks setOfBooks = new SetOfBooks();
        setOfBooks.add(1, "sell", new Orderok(1, 7.5, 3));
        setOfBooks.add(1, "sell", new Orderok(2, 10.9, 2));
        setOfBooks.add(1, "buy", new Orderok(3, 7.7, 6));
        setOfBooks.delete(1, 3);
        assertThat(setOfBooks.toString(), is("1buysell 10.9 2 2 "));
    }

    @Test
    /**
     * проверка конструктора SetOfBooks(String[] orderArray).
     * В качестве параметра передается массив заявок
     * конструктор заполняет setOfBooks заявками
     */
    public void setOfBooksTest() {
        String[] orderArray = {"<AddOrder book=\"book-1\" operation=\"SELL\" price=\"100.50\" volume=\"81\" orderId=\"1\" />", "<AddOrder book=\"book-1\" operation=\"BUY\" price=\" 99.70\" volume=\"16\" orderId=\"3\" />", "<DeleteOrder book=\"book-1\" orderId=\"3\" />"};
        assertThat(new SetOfBooks(orderArray).toString(), is("1buysell 100.5 81 1 "));
    }

    @Test
    /**
     * проверка метода stringOfSetOfBooks().
     * меоод возвращает содержимое setOfBooks
     * с объединенными заявками
     */
    public void stringOfSetOfBooksTest() {
        String[] orderArray = {"<AddOrder book=\"book-1\" operation=\"SELL\" price=\"100.50\" volume=\"81\" orderId=\"1\" />", "<AddOrder book=\"book-1\" operation=\"BUY\" price=\" 99.70\" volume=\"16\" orderId=\"3\" />", "<DeleteOrder book=\"book-1\" orderId=\"3\" />"};
        assertThat(new SetOfBooks(orderArray).stringOfSetOfBooks().toString(), is("book number 1\n" + "Продажа:\n" + "81 100.5\n" + "Покупка:\n"));
    }

}
