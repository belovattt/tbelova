package ru.job4j.exchange;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * класс для создания упорядоченного по убыванию цены списка заявок.
 */
public class OrderedList extends TreeMap<Double, SamePrice> {
    /**
     * конструктор.
     */
    OrderedList() {
        super();
    }

    /**
     * конструктор.
     *
     * @param comparator - порядок сортировки
     */
    OrderedList(Comparator comparator) {
        super(comparator);
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
                while ((order.getVolume() != 0) && (! this.isEmpty()) && (this.firstKey() <= order.getPrice())) {
                    Double key = this.firstKey();
                    SamePrice samePrice = this.get(key);
                    this.remove(key);
                    order = samePrice.checkOrder(order);
                    if (! samePrice.isEmpty()) {
                        this.put(key, samePrice);
                    }
                }
            }

        return order;
    }


    /**
     * метод проверяет, есть ли в книге ордеры, подходящие для покупки.
     * Если есть, они совсем удаляются из книги или их количество уменьшается (в зависимости от количества акций в order.
     *
     * @param order - order
     * @return order с измененным volume
     */

    public Order checkSellOrder(Order order) {
        if (!this.isEmpty()) {
            while ((order.getVolume() != 0) && (! this.isEmpty()) && (this.firstKey() >= order.getPrice())) {
                Double key = this.firstKey();
                SamePrice samePrice = this.get(key);
                this.remove(key);
                order = samePrice.checkOrder(order);
                if (! samePrice.isEmpty()) {
                    this.put(key, samePrice);
                }
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
        for (Double key : this.keySet()) {
            result.append(key.toString() + " ");
            result.append(this.get(key).itogo() + "\n");
        }
        return result.toString();
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
            for (Double key : this.keySet()) {
                if (this.get(key).remove(id) != null) {
                    result = true;
                    if (this.get(key).isEmpty()) {
                        this.remove(key);
                    }
                    break;
                }
            }
        }
        return result;
    }


    /**
     * метод выводит в консоль содержимое списка.
     */
    public StringBuffer stringOutput() {
        StringBuffer result = new StringBuffer();
        for (Double price : this.keySet()) {
            result.append(price.toString() + " " + this.get(price).itogo() + "\n");

        }
        return result;
    }
}

