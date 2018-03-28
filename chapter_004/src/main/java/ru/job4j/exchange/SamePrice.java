package ru.job4j.exchange;

import java.util.TreeMap;

public class SamePrice extends TreeMap<Integer, Order> {

    /**
     * метощ перебирает по ключу все заявки из карты и удаляет количество акций, соответствующее order.
     * возвращает null, елси заявка полностью удовлетворена
     * или order с уменьшенным количеством акций
     *
     * @param order - заявка
     * @return order
     */
    public Order checkOrder(Order order) {
        while ((order.getVolume() != 0) && (!this.isEmpty())) {
            Integer first = this.firstKey();
            Order ord = this.get(first);
            this.remove(first);
            int min = Math.min(order.getVolume(), ord.getVolume());
            order.setVolume(order.getVolume() - min);
            ord.setVolume(ord.getVolume() - min);
            if (ord.getVolume() != 0) {
                this.put(first, ord);
            }
        }
        return order;
    }

    public int itogo() {
        int result = 0;
        for (Integer id : this.keySet()) {
            result = result + this.get(id).getVolume();
        }
        return result;
    }
}
