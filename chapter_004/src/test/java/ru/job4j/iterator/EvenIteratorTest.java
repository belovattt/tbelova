package ru.job4j.iterator;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class EvenIteratorTest {
    @Test
    /**
     * если следующий элемент есть, метод hasNext() возвращает true
     */

    public void ifNumbersHasNextThenTrue() {
        int [] numbers = {1, 3, 4, 6, 5, 7, 2, 9};
        assertTrue(new EvenIterator(numbers).hasNext());
    }
    @Test
    /**
     * если следующий элемент есть, метод next() возвращает этот элемент
     */
    public void ifNextThenReturn4() {
        int [] numbers = {1, 3, 4, 6, 5, 7, 2, 9};
        assertThat(new EvenIterator(numbers).next(), is(4));
    }
    @Test
    /**
     * если сначала вызвать hasNext(), потом next(), метод вернет нужный элемент
     */
    public void ifHasNextAndNextThenReturn4() {
        int [] numbers = {1, 3, 4, 6, 5, 7, 2, 9};
        Iterator it = new EvenIterator(numbers);
        it.hasNext();
        assertThat(it.next(), is(4));
    }
    @Test
    /**
     * если два раза вызвать hasNext(), потом next(), метод вернет нужный элемент
     */
    public void ifHasNextAndHasNextAndNextThenReturn4() {
        int [] numbers = {1, 3, 4, 6, 5, 7, 2, 9};
        Iterator it = new EvenIterator(numbers);
        it.hasNext();
        it.hasNext();
        assertThat(it.next(), is(4));
    }
    @Test
    /**
     * если два раза вызвать next(), метод вернет нужный элемент
     */
    public void ifNextAndNextThenReturn6() {
        int [] numbers = {1, 3, 4, 6, 5, 7, 2, 9};
        Iterator it = new EvenIterator(numbers);
        it.next();
        assertThat(it.next(), is(6));
    }
    @Test
    /**
     * если четных элементов больше нет, hasNext() вернет false
     */
    public void ifNoEvenElementsThenHasNextReturnFalse() {
        int [] numbers = {1, 3, 4, 5, 7};
        Iterator it = new EvenIterator(numbers);
        it.next();
        assertFalse(it.hasNext());
    }
    @Test
    /**
     * если четных элементов больше нет, next() выбрасывает исключение
     */
    public void ifNoEvenElementsThenNextTrowException() {
        boolean result = false;
        int [] numbers = {1, 3, 4, 5, 7};
        Iterator it = new EvenIterator(numbers);
        it.next();
        try{
            it.next();
        } catch (NoSuchElementException nsee) {
            result = true;
        }
        assertTrue(result);
    }
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        Iterator it = new EvenIterator(numbers);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
    }



}
