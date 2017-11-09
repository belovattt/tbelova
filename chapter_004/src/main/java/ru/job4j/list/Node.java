package ru.job4j.list;

/**
 * класс определяет связанный список и метод, проверяющий, есть ли в списке
 * циклические ссылки
 * @param <T> - тип данных
 */

public class Node<T> {
    /**
     * данные.
     */
    private T value;
    /**
     * ссылка на следующий элемент.
      */

    private Node<T> next;

    /**
     * конструктор.
     * @param value - данные
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * метод возвращает ссылку на следующий элемент
     * @return ссылка
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * метод задает ссылку на следующий элемент.
     * @param next - ссылка
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * метод проверяет наличие циклических ссылок в списке
     * @param first - первый элемент списка
     * @return true, если циклические ссылки есть
     */

    public static boolean hasCycle(Node first) {
        boolean result = false;
        Node pointer = first;
            while (pointer.next != null) {
                if (pointer == pointer.next) {
                    result = true;
                    break;
                } else {
                    Node runner = first;
                    while (runner != pointer) {
                        if (runner == pointer.next) {
                            result = true;
                            break;
                        }
                        runner = runner.next;
                    }
                    if (result) {
                        break;
                    }
                    pointer = pointer.next;
                }
            }


        return result;
    }
}
