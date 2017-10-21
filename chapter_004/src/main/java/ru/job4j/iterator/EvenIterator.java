package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator реализует итератор, возвращающий только четные числа из одномерного массива.
 *
 * @author Tatyana Belova
 * @since 15.10.2017
 */
public class EvenIterator implements Iterator {
    /**
     * массив целых чисел
     */
    private int[] numbers;
    /**
     * позиция, с которой начинаем искать следующий элемент.
     * если метод hasNext() для такой позиции итератора уже выполнялся и
     * следующий элемент существует,
     * pointer содержит его номер, чтобы не ходить по массиву несколько раз
     */
    private int pointer;


    /**
     * Конструктор обнуляет текущую позицию итератора.
     * Поиска элементов еще не было.
     *
     * @param numbers - массив целых чисел
     */
    EvenIterator(int[] numbers) {
        this.numbers = numbers;
        this.pointer = 0;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     * Если следующий элемент найден, метод меняет значение поля pointer на номер найденного элемента
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = this.pointer; i < this.numbers.length; i++) {
            if (this.numbers[i] % 2 == 0) {
                result = true;
                this.pointer = i;
                break;
            }
        }

        return result;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() throws NoSuchElementException {
        int result = 0;
        if (this.hasNext()) {
            result = this.numbers[this.pointer];
            this.pointer++;
        } else {
            throw new NoSuchElementException("No even elements");
        }
        return result;
    }
}
