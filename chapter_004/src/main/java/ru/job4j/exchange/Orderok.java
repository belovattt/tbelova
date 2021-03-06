package ru.job4j.exchange;

/**
 * Класс Orderok.
 * Для хранения одной заявки
 */
public class Orderok implements Comparable {
    /**
     * цена.
     */
    private Double price;
    /**
     * id
     */
    private int id;
    /**
     * количество акций.
     */
    private int volume;

    /**
     * конструктор.
     *
     * @param id     - id
     * @param price  - цена
     * @param volume - количество
     */
    public Orderok(int id, double price, int volume) {
        this.price = price;
        this.volume = volume;
        this.id = id;
    }

    /**
     * метод возвращает id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * метод записывает id.
     *
     * @param id - id
     */

    public void setId(int id) {
        this.id = id;
    }


    /**
     * метод возвращает цену.
     *
     * @return цена
     */
    public Double getPrice() {
        return price;
    }

    /**
     * метод записывает цену.
     *
     * @param price - цена
     */
    public void setPrice(Double price) {
        this.price = price;
    }


    /**
     * метод возвращает количество акций.
     *
     * @return количество
     */
    public int getVolume() {
        return volume;
    }

    /**
     * метод записывает количество акций.
     *
     * @param volume - количество
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        int result = -1;
        Orderok ord = (Orderok) o;
        if (this.price > ord.getPrice()) {
            result = 1;
        } else {
            if (Math.abs(this.price - ord.getPrice()) < 0.01) {
                result = 0;
            }
        }
        return result;
    }


    /**
     * метод возвращает содержимое заявки в виде строки.
     *
     * @return цена количество id
     */
    @Override
    public String toString() {
        return " " + this.price + " " + this.volume + " " + this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orderok)) return false;

        Orderok orderok = (Orderok) o;

        if (id != orderok.id) return false;
        if (volume != orderok.volume) return false;
        return price.equals(orderok.price);
    }

    @Override
    public int hashCode() {
        int result = price.hashCode();
        result = 31 * result + id;
        result = 31 * result + volume;
        return result;
    }
}
