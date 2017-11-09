package ru.job4j.list;

import java.util.NoSuchElementException;

public abstract class SimpleStructure<E> extends DinList<E> {
    /**
     * конструктор.
     */
    public SimpleStructure() {
        super();
    }
    /**
     * метод возвращает данные из первого элемента структуры и удаляет этот элемент из структуры
     * @return данные
     * @throws NoSuchElementException - если структура пустая
     */
    public E poll() throws NoSuchElementException {
        E result = null;
        if (this.getHead() == null) {
            throw new NoSuchElementException();
        } else {
            result = this.getHead().getData();
            this.setHead(this.getHead().getNext());
            if (this.getHead() != null) {
                this.getHead().setPrev(null);
            }
        }
        return result;
    }

    /**
     * метод добавляет данные в структуру
     * @param value - данные
     */
   public abstract void push (E value);
}
