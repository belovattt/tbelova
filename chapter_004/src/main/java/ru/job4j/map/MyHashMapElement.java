package ru.job4j.map;

/**
 * класс для элементов MyHashMap
 */

public class MyHashMapElement {
    /**
     * метод возвращает поле value.
     *
     * @return value
     */

    public Object getValue() {
        return value;
    }

    /**
     * метод возвращает значение поля key.
     *
     * @return key
     */
    public Object getKey() {
        return key;
    }

    /**
     * ключ.
     */
    private Object key;

    /**
     * значение.
     */
    private Object value;

    /**
     * констуктор.
     *
     * @param key   - key
     * @param value - value
     */
    public MyHashMapElement(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
