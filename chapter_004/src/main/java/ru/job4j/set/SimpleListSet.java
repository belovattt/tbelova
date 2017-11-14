package ru.job4j.set;

import ru.job4j.list.ListElement;

import java.util.Iterator;

public class SimpleListSet<E> implements Iterable<E> {
    /**
     * указатель на начало списка.
     */
    private ListElement<E> head;
    /**
     * указатель на конец списка.
     */
    private ListElement<E> tail;

    /**
     * конструктор.
     * создает пустой список
     */
    public SimpleListSet() {
        this.head = null;
        this.tail = null;
    }
    /**
     * метод возвращает ссылку на начало списка.
     * @return ссылка на начало списка
     */
    public ListElement<E> getHead() {
        return head;
    }

    /**
     * метод возвращает ссылку на последний элемент списка.
     * @return ссылка на последний элемент
     */
    public ListElement<E> getTail() {
        return tail;
    }
    /**
     * метод добавляет элемент в список и записывает в него данные
     * если элемент с такими данными в списке уже есть, выбрасывается исключение
     * @param value - данные
     */
    public void add(E value) throws ValueAlreadyExistException {
        ListElement<E> runner = this.head;
        while (runner != null) {
            if (runner.getData().equals(value)) {
                throw new ValueAlreadyExistException("");
            }
            runner = runner.getNext();
        }
        ListElement<E> el = new ListElement(value);

        if (this.head != null) {
            el.setPrev(tail);
            tail.setNext(el);
            tail = el;
        } else {
            this.head = el;
            this.tail = el;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleListSetIterator<E>(this);
    }
}
