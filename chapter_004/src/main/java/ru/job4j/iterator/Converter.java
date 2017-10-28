package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter реализует реализует метод convert, принимающий итератор итераторов и возвращающий итератор.
 *
 * @author Tatyana Belova
 * @since 28.10.2017
 */

public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> list) {

        return new OneIterator(list);
    }
}

/**
 * класс OneIterator реализует итератор для итератора итераторов.
 */
class OneIterator implements Iterator<Integer> {
    /**
     * итератор итераторов.
     */
    private Iterator<Iterator<Integer>> it = null;
    /**
     * текущий итератор.
     */
    private Iterator<Integer> nextIterator = null;

    /**
     * конструктор.
     * если итератор итераторов не пустой, текущим итератором становится первый.
     *
     * @param it - итератор итераторов
     */

    OneIterator(Iterator<Iterator<Integer>> it) {
        this.it = it;
        if (this.it.hasNext()) {
            this.nextIterator = this.it.next();
        }
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
        boolean result = false;
        //если итератор итераторов изначально не был пустым
        if (nextIterator != null) {
            //если текущий итератор прошел не по всем элементам
            if (nextIterator.hasNext()) {
                result = true;
            } else {
                //если текущий итератор прошел по всем элементам, ищем следующий непустой итератор в итераторе итераторов
                while (this.it.hasNext()) {
                    nextIterator = this.it.next();
                    if (nextIterator.hasNext()) {
                        result = true;
                        break;
                    }
                }
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
        Integer result;
        if (this.hasNext()) {
            result = nextIterator.next();
        } else {
            throw new NoSuchElementException("no more elements");
        }
        return result;
    }

}

