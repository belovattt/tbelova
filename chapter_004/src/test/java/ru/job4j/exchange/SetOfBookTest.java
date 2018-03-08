package ru.job4j.exchange;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SetOfBookTest {
    @Test
    public void addTest() {
        SetOfBooks setOfBooks = new SetOfBooks();
        setOfBooks.add(1, "sell", new Order(1, 7.5, 1));
        setOfBooks.add(1, "sell", new Order(2, 10.9, 2));
        setOfBooks.add(1, "buy", new Order(3, 7.7, 8));
        setOfBooks.add(1, "sell", new Order(4, 11, 2));
        setOfBooks.add(1, "buy", new Order(5, 10.9, 2));
        System.out.println(setOfBooks.toString());
    }
    @Test
    public void deleteTest() {
        SetOfBooks setOfBooks = new SetOfBooks();
        setOfBooks.add(1, "sell", new Order(1, 7.5, 3));
        System.out.println(setOfBooks.toString());
        setOfBooks.add(1, "sell", new Order(2, 10.9, 2));
        System.out.println(setOfBooks.toString());
        setOfBooks.add(1, "buy", new Order(3, 7.7, 6));
        System.out.println(setOfBooks.toString());
        setOfBooks.delete(1, 3);
        System.out.println(setOfBooks.toString());
    }

}
