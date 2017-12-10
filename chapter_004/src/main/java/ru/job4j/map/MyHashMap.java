package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Класс реализует HashMap на основе массива без реализации коллизий.
 * @param <K> ключ
 * @param <V> значение
 */
public class MyHashMap<K, V> implements Iterable<V> {
    /**
     * метод возвращает массив значений
     * @return массив
     */
    public MyHashMapElement[] getTable() {
        return table;
    }

    /**
     * массив для хранения объектов.
     */
    private MyHashMapElement[] table;

    /**
     * метод возвращает размерность массива значений.
     * @return размерность
     */

    public int getSize() {
        return size;
    }

    /**
     * размерность массива, по умолчанию 16.
     */
    private int size = 16;
    /**
     * коэффициент заполнения массива, по умолчанию 0.75.
     */
    private double capacity = 0.75;
    /**
     * количество заполненных элемнтов.
     */
    private int amount = 0;

    /**
     * конструктор без параметров.
     * по умолчанию размерность массива 16,
     * коэффициент заполнения 0.75
     */
    public MyHashMap() {
        this.table = new MyHashMapElement[this.size];
    }

    /**
     * конструктор для карты с заданным количеством элементов.
     * @param power - число для определения размерности массива по формуле pow(2, power)
     */
    public MyHashMap(int power) {
        this.size = (int) Math.pow(2, power);
        this.table = new MyHashMapElement[this.size];
    }

    /**
     * конструктор для карты с заданным количеством элементов и заданным коэффициентом заполнения.
     * @param power - число для определения размерности массива по формуле pow(2, power)
     * @param capacity - коэффициент заполнения
     */
    public MyHashMap(int power, double capacity) {
        this.size = (int) Math.pow(2, power);
        this.capacity = capacity;
        this.table = new MyHashMapElement[this.size];
    }

    /**
     * метод вставляет в HashMap пару (ключ, значение).
     * если массив заполнен более чем на 75%, его размерность удваивается
     * @param key - ключ
     * @param value - значение
     * @return true, если пары с таким ключом еще не было
     */
    public boolean insert(K key, V value) {
        boolean result = false;
        if (this.amount > this.capacity * this.size) {
            this.size *= 2;
            MyHashMapElement[] newTable = new MyHashMapElement[this.size];
            for (int i = 0; i < this.table.length; i++) {
                if (this.table[i] != null) {
                 newTable[this.tableIndex((K) this.table[i].getKey())] = this.table[i];
                }
            }
            this.table = newTable;
        }
        if (this.table[this.tableIndex(key)] == null) {
            MyHashMapElement el = new MyHashMapElement(key, value);
            this.table[this.tableIndex(key)] = el;

            this.amount++;
            result = true;
        }
        return result;
    }

    /**
     * метод возвращает значение по ключу.
     * @param key - ключ
     * @return значение
     * @throws NoSuchElementException, если значения с таким ключом нет
     */
    public V get(K key) throws NoSuchElementException {

        if (this.table[this.tableIndex(key)] == null) {
            throw new NoSuchElementException((""));
        }
        return ((V) this.table[this.tableIndex(key)].getValue());
    }

    /**
     * метод удаляет значение по ключу.
     * @param key - ключ
     * @return екгу, если значение удалено, false, если такого ключа нет
     */
    public boolean delete(K key) {
        boolean result = false;
        if (table[this.tableIndex(key)] != null) {
            table[this.tableIndex(key)] = null;
            result = true;
        }
        return result;
    }

    /**
     * метод вычисляет индекс элемента массива для заданного ключа и текущей размерности массива.
     * @param key - ключ
     * @return индекс для вставки элемента
     */
    private int tableIndex(K key) {
        return hash(key) & (this.size - 1);
    }

    /**
     * вычисляет хэш для уменьшения количества коллизий.
     * @param key
     * @return хэш
     */
    private static int hash(Object key) {
        return key.hashCode() ^ key.hashCode() >>> 16;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        return new MyHashMapIterator<K, V>(this);
    }

}
