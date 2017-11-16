package ru.job4j.set;

import ru.job4j.list.DinList;
import ru.job4j.list.ListElement;

import java.util.Iterator;

public class SimpleListSet<E> extends DinList<E> {


    /**
     * конструктор.
     * создает пустой список
     */
    public SimpleListSet() {
        super();
    }

    /**
     * метод добавляет элемент в список и записывает в него данные
     * если элемент с такими данными в списке уже есть, выбрасывается исключение
     *
     * @param value - данные
     */
    public void add(E value) throws ValueAlreadyExistException {
        Iterator<E> it = this.iterator();
        for (E el : this) {
            if (el.equals(value)) {
                throw new ValueAlreadyExistException("");
            }
        }
        super.add(value);
    }
}
