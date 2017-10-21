package ru.job4j.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class PrimeIterator реализует итератор, возвращающий только простые числа из одномерного массива.
 *
 * @author Tatyana Belova
 * @since 21.10.2017
 */
public class PrimeIterator implements Iterator {
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
     * сюда все итераторы будут записывать простые числа, чтобы не проверять второй раз
     */
    static HashSet<Integer> primeSet = new HashSet<>();

    /**
     * Конструктор обнуляет текущую позицию итератора.
     * Поиска элементов еще не было.
     *
     * @param numbers - массив целых чисел
     */
    PrimeIterator(int[] numbers) {
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
            if (isPrime(this.numbers[i])) {
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
            throw new NoSuchElementException("No prime elements");
        }
        return result;
    }

    static boolean isPrime(int element) {
        boolean result = true;
        if (element == 1) {
            result = false;
        } else {
            double sqrt = Math.pow(element, 0.5);
            if (! primeSet.contains(element)) {
                int i = 2;
                while (i <= sqrt) {
                    if (element % i == 0) {
                        result = false;
                        break;
                    }
                    i++;
                }
                if (result) {
                    primeSet.add(element);
                }
            }
        }
        return result;
    }
}

