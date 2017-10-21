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
     * (массивы бывают очень длинные)
     */
    private int pointer;
    /**
     * выполнялся ли метод hasNext() для текущей позиции итератора
     */
    private boolean wasHasNext;
    /**
     * был ли найден следующий элемент
     */
    private boolean hasNextReturnTrue;

    /**
     * Конструктор обнуляет текущую позицию итератора.
     * Поиска элементов еще не было.
     *
     * @param numbers - массив целых чисел
     */
    EvenIterator(int[] numbers) {
        this.numbers = numbers;
        this.pointer = 0;
        this.wasHasNext = false;
        this.hasNextReturnTrue = false;

    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     * Если следующий элемент найден, метод меняет значение поля pointer на номер найденного элемента
     * значение поля wasHasNext меняется на true
     * в поле hasNextReturnTrue записывается результат поиска
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        //если для такой позиции итератора hasNext() уже вызывался
        if (this.wasHasNext) {
            result = hasNextReturnTrue;
        } else {
            for (int i = this.pointer; i < this.numbers.length; i++) {
                if (this.numbers[i] % 2 == 0) {
                    result = true;
                    this.pointer = i;
                    break;
                }
            }
            //чтобы второй раз не ходить
            this.wasHasNext = true;
            this.hasNextReturnTrue = result;
        }
        return result;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     *                                Метод проверяет, выполнялся ли метод hasNext() для текущей позиции итератора
     *                                если выполнялся, то
     *                                если результат hasNext() был false, выбрасывает исключение,
     *                                если true - записывает в result найденный элемент и сдвигает pointer на одну позицию
     *                                если не выполнялся, то выполняет hasNext()
     */
    @Override
    public Integer next() throws NoSuchElementException {
        int result = 0;
        if (this.wasHasNext) {
            if (!this.hasNextReturnTrue) {
                throw new NoSuchElementException("No even elements");
            } else {
                result = this.numbers[this.pointer];
                this.pointer++;
            }
        } else {
            if (this.hasNext()) {
                result = this.numbers[this.pointer];
                this.pointer++;
            } else {
                throw new NoSuchElementException("No even elements");
            }
        }
        //тут еще не искали
        this.wasHasNext = false;
        this.hasNextReturnTrue = false;
        return result;
    }
}
