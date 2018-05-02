package ru.job4j.exchange;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * класс для создания упорядоченного по убыванию цены списка заявок.
 */
public class OrderedList {
    private TreeMap<Double, SamePrice> orderedList;
    /**
     * конструктор.
     */
    OrderedList() {
        this.orderedList = new TreeMap<>();
    }

    /**
     * конструктор.
     *
     * @param comparator - порядок сортировки
     */
    OrderedList(Comparator comparator) {
        this.orderedList = new TreeMap<>(comparator);
    }

    /**
     * метод проверяет, есть ли в книге ордеры, подходящие для продажи.
     * Если есть, они совсем удаляются из книги или их количество уменьшается (в зависимости от количества акций в orderok.
     *
     * @param orderok - orderok
     * @return orderok с измененным volume или null, если запрос полностью реализован
     */

    public Orderok checkBuyOrder(Orderok orderok) {


            if (!this.orderedList.isEmpty()) {
                while ((orderok.getVolume() != 0) && (! this.orderedList.isEmpty()) && ((double) this.orderedList.firstKey() <= orderok.getPrice())) {
                    Double key = this.orderedList.firstKey();
                    SamePrice samePrice = this.orderedList.get(key);
                    this.orderedList.remove(key);
                    orderok = samePrice.checkOrder(orderok);
                    if (! samePrice.isEmpty()) {
                        this.orderedList.put(key, samePrice);
                    }
                }
            }

        return orderok;
    }


    /**
     * метод проверяет, есть ли в книге ордеры, подходящие для покупки.
     * Если есть, они совсем удаляются из книги или их количество уменьшается (в зависимости от количества акций в orderok.
     *
     * @param orderok - orderok
     * @return orderok с измененным volume
     */

    public Orderok checkSellOrder(Orderok orderok) {
        if (!this.orderedList.isEmpty()) {
            while ((orderok.getVolume() != 0) && (! this.orderedList.isEmpty()) && ((double)this.orderedList.firstKey() >= (double)orderok.getPrice())) {
                Double key = this.orderedList.firstKey();
                SamePrice samePrice = this.orderedList.get(key);
                this.orderedList.remove(key);
                orderok = samePrice.checkOrder(orderok);
                if (! samePrice.isEmpty()) {
                    this.orderedList.put(key, samePrice);
                }
            }
        }
        return orderok;
    }

    /**
     * метод возвращает содержимое списка в виде строки.
     *
     * @return строка
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Double key : this.orderedList.keySet()) {
            result.append(key.toString() + " ");
            result.append(this.orderedList.get(key).itogo() + "\n");
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
        if (!this.orderedList.isEmpty()) {
            for (Double key : this.orderedList.keySet()) {
                if (this.orderedList.get(key).remove(id) != null) {
                    result = true;
                    if (this.orderedList.get(key).isEmpty()) {
                        this.orderedList.remove(key);
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
        for (Double price : this.orderedList.keySet()) {
            result.append(price.toString() + " " + this.orderedList.get(price).itogo() + "\n");

        }
        return result;
    }
    public boolean containsKey(Double d) {
        return this.orderedList.containsKey(d);
    }
    public SamePrice get (Double d) {
        return this.orderedList.get(d);
    }
    public void put (Double d, SamePrice samePrice) {
        this.orderedList.put(d, samePrice);
    }
}

