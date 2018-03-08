package ru.job4j.exchange;

import java.util.Iterator;

/**
 * класс для создания упорядоченного по убыванию цены списка заявок.
 */
public class OrderedList implements Iterable<Order> {
    /**
     * метод возвращает указатель на начало списка.
     *
     * @return head
     */
    public Order getHead() {
        return head;
    }

    /**
     * указатель на первый элемент.
     */
    private Order head = null;
    /**
     * указатель на последний элемент.
     */
    private Order tail = null;

    /**
     * метод добавляет заявку в упорядоченный список.
     *
     * @param order - заявка
     */
    public void add(Order order) {
        if (order.getVolume() != 0) {
            if (this.head == null) {
                this.head = order;
                this.tail = order;
            } else {
                Order runner = head;
                while ((runner != null) && (runner.compareTo(order) > 0)) {
                    runner = runner.getNext();
                }
                if (runner == null) {
                    this.tail.setNext(order);
                    order.setPrev(this.tail);
                    this.tail = order;
                } else {
                    if (runner == this.head) {
                        order.setNext(this.head);
                        this.head.setPrev(order);
                        this.head = order;
                    } else {
                        runner.getPrev().setNext(order);
                        order.setPrev(runner.getPrev());
                        order.setNext(runner);
                        runner.setPrev(order);
                    }
                }

            }
        }
    }


    /**
     * метод проверяет, есть ли в книге ордеры, подходящие для продажи.
     * Если есть, они совсем удаляются из книги или их количество уменьшается (в зависимости от количества акций в order.
     *
     * @param order - order
     * @return order с измененным volume или null, если запрос полностью реализован
     */

    public Order checkBuyOrder(Order order) {
        if (!this.isEmpty()) {
            Order runner = this.tail;
            while ((runner != null) && (runner.compareTo(order) <= 0) && (order.getVolume() > 0)) {
                if (order.getVolume() >= runner.getVolume()) {
                    Order prevOrder = runner.getPrev();
                    order.setVolume(order.getVolume() - runner.getVolume());
                /*
                если удаляемый элемент последний, но не единственный
                 */
                    if ((runner == tail) && (head != tail)) {
                        runner.getPrev().setNext(null);
                        tail = runner.getPrev();
                    } else {
                    /*
                    если удаляемый элемент единственный
                     */
                        if ((runner == tail) && (head == tail)) {
                            head = null;
                            tail = null;
                        } else {
                        /*
                        если удаляемый элемент первый, но не единственный
                         */
                            if (runner == head) {
                                runner.getNext().setPrev(null);
                                head = runner.getNext();
                            } else {
                                /*
                                если удаляемый элемент в середине
                                 */
                                runner.getNext().setPrev(runner.getPrev());
                                runner.getPrev().setNext(runner.getNext());
                            }
                        }
                    }
                    runner = prevOrder;
                } else {
                    runner.setVolume(runner.getVolume() - order.getVolume());
                    order.setVolume(0);
                }
            }
            if (order.getVolume() == 0) {
                order = null;
            }
        }
        return order;
    }

    /**
     * метод проверяет, есть ли в книге ордеры, подходящие для покупки.
     * Если есть, они совсем удаляются из книги или их количество уменьшается (в зависимости от количества акций в order.
     *
     * @param order - order
     * @return order с измененным volume или null, если запрос полностью реализован
     */

    public Order checkSellOrder(Order order) {
        if (!this.isEmpty()) {
            Order runner = this.head;
            while ((runner != null) && (runner.compareTo(order) >= 0) && (order.getVolume() > 0)) {
                if (order.getVolume() >= runner.getVolume()) {
                    Order nextOrder = runner.getNext();
                    order.setVolume(order.getVolume() - runner.getVolume());
                /*
                если удаляемый элемент последний, но не единственный
                 */
                    if ((runner == tail) && (head != tail)) {
                        runner.getPrev().setNext(null);
                        tail = runner.getPrev();
                    } else {
                    /*
                    если удаляемый элемент единственный
                     */
                        if ((runner == tail) && (head == tail)) {
                            head = null;
                            tail = null;
                        } else {
                        /*
                        если удаляемый элемент первый, но не единственный
                         */
                            if (runner == head) {
                                runner.getNext().setPrev(null);
                                head = runner.getNext();
                            } else {
                                /*
                                если удаляемый элемент в середине
                                 */
                                runner.getNext().setPrev(runner.getPrev());
                                runner.getPrev().setNext(runner.getNext());
                            }
                        }
                    }
                    runner = nextOrder;
                } else {
                    runner.setVolume(runner.getVolume() - order.getVolume());
                    order.setVolume(0);
                }
            }
            if (order.getVolume() == 0) {
                order = null;
            }
        }
        return order;
    }

    /**
     * метод возвращает содержимое списка в виде строки.
     *
     * @return строка
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        Order runner = this.head;
        while (runner != null) {
            result.append(runner.toString());
            runner = runner.getNext();
        }
        return result.toString();
    }

    /**
     * метод проверяет, является ли список пустым.
     *
     * @return true, если список пустой
     */
    public boolean isEmpty() {
        return this.head == null;
    }

    /**
     * метод ищет в списке заявку с указанным id и удаляет ее, если нашел.
     *
     * @param id - id
     * @return true, если нашел и удалил
     */
    public boolean deleteOrderOnId(int id) {
        boolean result = false;
        if (!this.isEmpty()) {
            Order runner = this.head;
            while ((runner != null) && (runner.getId() != id)) {
                runner = runner.getNext();
            }
            if (runner != null) {
                result = true;
                if (runner == head) {
                    if (head.getNext() != null) {
                        head.getNext().setPrev(null);
                        head = head.getNext();
                    } else {
                        head = null;
                        tail = null;
                    }
                } else {
                    if (runner == tail) {
                        if (tail.getPrev() != null) {
                            tail.getPrev().setNext(null);
                            tail = tail.getPrev();
                        } else {
                            tail = null;
                            head = null;
                        }
                    } else {
                        runner.getPrev().setNext(runner.getNext());
                        runner.getNext().setPrev(runner.getPrev());
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Order> iterator() {
        return null;
    }

    /**
     * метод выводит в консоль содержимое списка.
     */
    public StringBuffer stringOutput() {
        StringBuffer result = new StringBuffer();
        OrderedListIterator it = new OrderedListIterator(this);
        double sellOrderPrice = 0;
        double oldPrice = 0;
        double newPrice = 0;
        int volume = 0;
        Order order = null;
        if (it.hasNext()) {
            order = it.next();
            oldPrice = order.getPrice();
            volume = order.getVolume();
        }
        while (it.hasNext()) {
            order = it.next();
            newPrice = order.getPrice();
            if (oldPrice == newPrice) {
                volume = volume + order.getVolume();
            } else {
                if (volume != 0) {
                    result.append(volume + " " + oldPrice + "\n");
                }
                oldPrice = newPrice;
                volume = order.getVolume();
            }

        }
        if (volume != 0) {
            result.append(volume + " " + oldPrice + "\n");
        }
        return result;
    }
}

