package ru.job4j.list;

/**
 * класс реализует один элемент динамического двунаправленного списка
 *
 * @param <E> - тип данных
 */
public class ListElement<E> {
    /**
     * данные
     */
    private E data;
    /**
     * ссылка на предыдущий элемент
     */
    private ListElement<E> next;
    /**
     * ссылка на следующий элемент
     */
    private ListElement<E> prev;

    /**
     * конструктор.
     * ссылки на следующий и предыдущий нулевые
     * @param data - данные
     */

    public ListElement(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    /**
     * метод возвращает данные, хранящиеся в элементе.
     * @return данные
     */
    public E getData() {
        return data;
    }

    /**
     * метод записывает данные в поле data.
     * @param data - данные
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * метод возвращает ссылку на следующий элемент.
     * @return ссылка на следующий элемент
     */
    public ListElement<E> getNext() {
        return next;
    }

    /**
     * метод устанавливает ссылку на следующий элемент.
     * @param next - ссылка на следующий элемент
     */
    public void setNext(ListElement<E> next) {
        this.next = next;
    }

    /**
     * метод возвращает ссылку на предыдущий элемент.
     * @return ссылка на предыдущий элемент
     */
    public ListElement<E> getPrev() {
        return prev;
    }

    /**
     * метод устанавливает ссылку на предыдущий элемент.
     * @param prev - ссылка на предыдущий элемент
     */
    public void setPrev(ListElement<E> prev) {
        this.prev = prev;
    }


}
