package ru.job4j.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * класс реализует динамический двунаправленный список на базе указателей
 * @param <E> - тип данных
 */
@ThreadSafe
public class DinList<E> implements Iterable<E> {

    /**
     * указатель на начало списка.
     */
    @GuardedBy("this")
    private ListElement<E> head;
    /**
     * указатель на конец списка.
     */
    @GuardedBy("this")
    private ListElement<E> tail;

    /**
     * конструктор.
     * создает пустой список
     */
     public DinList() {
        this.head = null;
        this.tail = null;
    }
    synchronized void setHead(ListElement<E> head) {
        this.head = head;
    }

     /**
     * метод возвращает ссылку на начало списка.
     * @return ссылка на начало списка
     */
    public synchronized ListElement<E> getHead() {
        return head;
    }

    /**
     * метод возвращает ссылку на последний элемент списка.
     * @return ссылка на последний элемент
     */
    public synchronized ListElement<E> getTail() {
        return tail;
    }

    /**
     * метод добавляет элемент в список и записывает в него данные
     * @param value - данные
     */
    public synchronized void add(E value) {
        ListElement<E> el = new ListElement<E>(value);
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
     * метод возвращает данные из элемента списка по порядковому номеру.
     * @param index - номер
     * @return данные
     * @throws NoSuchElementException - если элемента с таким номером нет
     */
    public synchronized E get(int index) throws NoSuchElementException {
        ListElement<E> runner = this.head;
        int i = 0;
        if (index < 0) {
            throw new NoSuchElementException();
        }
        while (i < index) {
            if (runner.getNext() != null)  {
                runner = runner.getNext();
                i++;
            } else {
                throw new NoSuchElementException();
            }
        }
        return runner.getData();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new DinListIterator(this);
    }
}
