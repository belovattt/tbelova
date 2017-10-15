package ru.job4j.iterator;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixIteratorTest {
    /**
     * Test for hasNext.
     * matrix has 4 elements
     * iterator is before the first element
     * the method should return true
     */
    @Test
    public void ifMatrixHasNextThenTrue() {
        Integer [][] matrix = {{1, 2}, {3, 4}};
        assertTrue(new MatrixIterator<Integer>(matrix).hasNext());

    }
    /**
     * Test for hasNext.
     * matrix has 4 elements
     * iterator is before the first element
     * the method should return true
     */
    @Test
    public void ifMatrixHasntNextThenFalse() {
        Integer [][] matrix = {{1, 2}, {3, 4}};
        MatrixIterator<Integer> mi = new MatrixIterator<Integer>(matrix);
        mi.next();
        mi.next();
        mi.next();
        mi.next();
        assertFalse(mi.hasNext());

    }
    /**
     * Test for next.
     * matrix has 4 elements
     * iterator is before the first element
     * the method should return the first element
     */
    @Test
    public void afterTheFirstCallMethodReturnFirstElement() {
        Integer [][] matrix = {{1, 2}, {3, 4}};
        assertThat(new MatrixIterator<Integer>(matrix).next(), is(1));
    }
    /**
     * Test for next.
     * matrix has 2x2 elements
     * the method is called 3 times
     * the method should return the first element of the second row
     */
    @Test
    public void afterTheThirdCallMethodReturnFirstElementOfSecondRow() {
        Integer [][] matrix = {{1, 2}, {3, 4}};
        MatrixIterator<Integer> mi = new MatrixIterator<Integer>(matrix);
        mi.next();
        mi.next();
        assertThat(mi.next(), is(3));
    }
    /**
     * Test for next.
     * matrix has 2x2 elements
     * the method is called 5 times
     * the method throw exception
     */
    @Test
    public void afterTheFifthCallMethodThrowException() {
        boolean result = false;
        Integer [][] matrix = {{1, 2}, {3, 4}};
        MatrixIterator<Integer> mi = new MatrixIterator<Integer>(matrix);
        mi.next();
        mi.next();
        mi.next();
        mi.next();
        try {
            mi.next();
        } catch (NoSuchElementException nsee) {
            result = true;
        }
        assertTrue(result);
    }
}
