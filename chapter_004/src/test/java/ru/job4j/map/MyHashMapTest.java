package ru.job4j.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * класс реализует тесты для методов класса MyHashMap.
 */

public class MyHashMapTest {

    @Test
    /**
     * вставляем в HashMap два значения с одинаковым ключом.
     * первый раз insert возвращает true, второй раз false
     * в HashMap остается первое значение
     */
    public void ifInsertTwoElementsWithSameKeysThenFalse() {
        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();

        myHashMap.insert("first", "element");
        boolean res = myHashMap.insert("first", "new element");

        String result = "";
        for (int i = 0; i < myHashMap.getSize(); i++) {
            if (myHashMap.getTable()[i] != null) {
                result = (String) myHashMap.getTable()[i].getValue();
                break;
            }
        }
        assertThat(result, is("element"));
        assertThat(res, is(false));
    }

    @Test
    /**
     * Вставляем в HashMap одно значение.
     * Метод insert возвращает true
     * элемент всавляется в массив
     */
    public void ifInsertOneElementThenTrue() {
        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
        boolean res = myHashMap.insert("first", "element");
        String result = "";
        for (int i = 0; i < myHashMap.getSize(); i++) {
            if (myHashMap.getTable()[i] != null) {
                result = (String) myHashMap.getTable()[i].getValue();
                break;
            }
        }
        assertThat(result, is("element"));
        assertThat(res, is(true));
    }

    @Test
    /**
     * По умолчанию HashMap создается для 16 элементов
     * Потом автоматически расширяется
     * Если вставить 17-й элемент, метощ insert вернет true
     */
    public void ifInsertSeventeenElementsThenTrue() {
        MyHashMap<Integer, String> myHashMap = new MyHashMap<Integer, String>();
        int i = 0;
        int count = 0;
        do {
            if (myHashMap.insert(i, "" + i)) {
                count++;
            }
            i++;
        } while (i < 16);
        assertThat(myHashMap.insert(++i, "" + i), is(true));
    }

    /**
     * Проверяем поиск элемента по ключу.
     * Если такой ключ есть, метод get возращает элемент,
     * иначе выбрасывает исключение NoSuchElementException
     */
    @Test(expected = NoSuchElementException.class)
    public void getTest() {
        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
        myHashMap.insert("first", "element");
        assertThat(myHashMap.get("first"), is("element"));
        myHashMap.get("second");
    }

    @Test
    /**
     * Проверяем удаление элемента по ключу.
     * Первый раз delete возвращает true,
     * второй раз для этого же ключа возвращает false
     */
    public void deleteTest() {
        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
        myHashMap.insert("first", "element");
        assertThat(myHashMap.delete("first"), is(true));
        assertThat(myHashMap.delete("first"), is(false));
    }

    /**
     * проверка итератора.
     */
    @Test(expected = NoSuchElementException.class)
    public void iteratorTest() {
        MyHashMap<String, String> myHashMap = new MyHashMap<String, String>();
        myHashMap.insert("first", "element");
        Iterator i = myHashMap.iterator();

        assertThat(i.hasNext(), is(true));
        assertThat(i.hasNext(), is(true));
        assertThat(i.next(), is("element"));
        assertThat(i.hasNext(), is(false));
        i.next();
    }
}
