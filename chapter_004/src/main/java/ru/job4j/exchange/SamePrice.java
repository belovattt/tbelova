package ru.job4j.exchange;

import java.util.TreeMap;

public class SamePrice {
    private TreeMap<Integer, Orderok> samePrice = new TreeMap<>();

    /**
     * метощ перебирает по ключу все заявки из карты и удаляет количество акций, соответствующее order.
     * возвращает null, елси заявка полностью удовлетворена
     * или order с уменьшенным количеством акций
     *
     * @param orderok - заявка
     * @return order
     */
    public Orderok checkOrder(Orderok orderok) {
        while ((orderok.getVolume() != 0) && (!this.samePrice.isEmpty())) {
            Integer first = this.samePrice.firstKey();
            Orderok ord = this.samePrice.get(first);
            this.samePrice.remove(first);
            int min = Math.min(orderok.getVolume(), ord.getVolume());
            orderok.setVolume(orderok.getVolume() - min);
            ord.setVolume(ord.getVolume() - min);
            if (ord.getVolume() != 0) {
                this.samePrice.put(first, ord);
            }
        }
        return orderok;
    }

    public int itogo() {
        int result = 0;
        for (Integer id : this.samePrice.keySet()) {
            result = result + this.samePrice.get(id).getVolume();
        }
        return result;
    }
    public boolean isEmpty() {
        return this.samePrice.isEmpty();
    }
    public Orderok remove(int id) {
       return this.samePrice.remove(id);
    }
    public void put (Integer in, Orderok orderok) {
        this.samePrice.put(in, orderok);
    }
}
