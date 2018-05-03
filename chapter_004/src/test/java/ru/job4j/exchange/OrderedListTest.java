package ru.job4j.exchange;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class OrderedListTest {


    @Test
    /**
     * метод должен добавлять элементы в список в порядке убывания цены.
     * элемент с той же ценой становится первым.
     */
    public void addTest() {
        //OrderedList list = new OrderedList();
        //list.put(10.25, new Orderok(12, 10.25, 5));
        //list.add(new Orderok(10, 9.50, 2));
       // list.add(new Orderok(5, 11.70, 4));
        //list.add(new Orderok(8, 10.25, 2));
        //assertThat(list.toString(), is(" 11.7 4 5 10.25 2 8 10.25 5 12 9.5 2 10"));
    }
 @Test
 /**
  * метод получает заявку на покупку и просматривает список заявок на продажу в поиске цены <= цены на покупку.
  * Если нашел, Уменьшает количество акций в заявке на продажу, пока не получит 0 или пока не выберет все
  * заявки на продажу.
  * Возвращает null, если заявка полностью удовлетворена, или заявку с оставшимся количеством акций
  */
 public void checkSellOrderTest() {
     OrderedList list = new OrderedList();
     //list.add(new Orderok(12, 10.25, 5));
     //list.add(new Orderok(10, 9.50, 2));
     //list.add(new Orderok(5, 11.70, 4));
     //list.add(new Orderok(8, 10.25, 2));
     Orderok orderok = new Orderok(4, 10.3, 4);
     orderok = list.checkSellOrder(orderok);
     assertThat(list.toString(), is(" 10.25 2 8 10.25 5 12 9.5 2 10"));
     assertThat(orderok == null, is(true));
     orderok = new Orderok(9, 10.0, 10);
     orderok = list.checkSellOrder(orderok);
     assertThat(orderok.toString(), is(" 10.0 3 9"));
     assertThat(list.toString(), is(" 9.5 2 10"));
 }
    @Test
    /**
     * метод получает заявку на покупку и просматривает список заявок на продажу в поиске цены <= цены на покупку.
     * Если нашел, Уменьшает количество акций в заявке на продажу, пока не получит 0 или пока не выберет все
     * заявки на продажу.
     * Возвращает null, если заявка полностью удовлетворена, или заявку с оставшимся количеством акций
     */
    public void checkBuyOrderTest() {
        OrderedList list = new OrderedList();
        //list.add(new Orderok(12, 10.25, 5));
        //list.add(new Orderok(10, 9.50, 5));
        //list.add(new Orderok(5, 11.70, 4));
        //list.add(new Orderok(8, 10.25, 2));
        Orderok orderok = new Orderok(4, 10.2, 2);
        orderok = list.checkBuyOrder(orderok);
        assertThat(list.toString(), is(" 11.7 4 5 10.25 2 8 10.25 5 12 9.5 3 10"));
        assertThat(orderok == null, is(true));
        orderok = new Orderok(9, 10.3, 12);
        orderok = list.checkBuyOrder(orderok);
        assertThat(orderok.toString(), is(" 10.3 2 9"));
        assertThat(list.toString(), is(" 11.7 4 5"));
    }
    @Test
    /**
     * Метод для проверки удаления заявки с указанным id из списка. Метод возвращает true, если заявка удалена,
     * и false, если ее не было в списке
     */
    public void deleteOrderOnIdTest() {
        OrderedList list = new OrderedList();
        //list.add(new Orderok(12, 10.25, 5));
       // list.add(new Orderok(10, 9.50, 2));
        //list.add(new Orderok(5, 11.70, 4));
        //list.add(new Orderok(8, 10.25, 2));
        list.deleteOrderOnId(8);
        assertThat(list.toString(), is(" 11.7 4 5 10.25 5 12 9.5 2 10"));
        assertThat(list.deleteOrderOnId(100), is(false));
    }
    @Test
    /**
     * Метод для проверки вывода содержимого списка заявок в строку.
     * Заявки с одинаковой ценой объединяются
     */
    public void stringOutputTest() {
        OrderedList list = new OrderedList();
        //list.add(new Orderok(12, 10.25, 5));
        //list.add(new Orderok(10, 9.50, 2));
       // list.add(new Orderok(5, 11.70, 4));
        //list.add(new Orderok(8, 10.25, 2));
        StringBuffer res = new StringBuffer();
        res.append("4 11.7\n" + "7 10.25\n" + "2 9.5\n");
        assertThat(list.stringOutput().toString(), is(res.toString()));

    }
}
