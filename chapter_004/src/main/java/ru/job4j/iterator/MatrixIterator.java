package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class MatrixIterator реализует итератор для двумерного массива с элементами типа T.
 *
 * @author Tatyana Belova
 * @since 15.10.2017
 */

public class MatrixIterator<T> implements Iterator {
    /**
     * матрица
     */
    private T [][] matrix;
    /**
     * номер строки
     */
    private int i;
    /**
     * номер столбца
     */
    private int j;

    /**
     * конструктор
     * @param matrix - матрица
     */
    MatrixIterator(T [][] matrix) {
        this.matrix = matrix;
        this.i = 0;
        this.j = 0;
    }
    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return (this.i <= this.matrix.length - 1) && (this.j <= this.matrix[0].length-1);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public T next() throws NoSuchElementException{
       T el = null;
        if (! this.hasNext()) {
            throw new NoSuchElementException("This array is over");
        } else {
            el = matrix[this.i][this.j];
            if (this.j == matrix[1].length - 1) {
               this.j = 0;
               this.i++;
            } else {
                this.j++;
            }
        }
        return el;
    }
}
