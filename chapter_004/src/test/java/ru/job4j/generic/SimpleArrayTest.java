package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {
    /**
     * тест проверяет, что два элемента добавляются в массив размерности 2
     */
    @Test
    public void addTwoElementsInArrayTest() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        assertThat(simplearr.get(0), is(1));
        assertThat(simplearr.get(1), is(2));
    }

    /**
     * тест проверяет, что при добавлении третьего элемента
     * в массив размерности 2 выбрасывается исключение SimpleArrayIsFullException
     */
    @Test(expected = SimpleArrayIsFullException.class)
    public void addThreeElementsInArrayTest() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        simplearr.add(3);
    }

    /**
     * тест проверяет, что при удалении первого элемента массива остальные элементы сдвигаются
     */
    @Test
    public void deleteTheFirstElement() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        simplearr.delete(0);
        assertThat(simplearr.get(0), is(2));
        //
        //simplearr.delete(0);
    }

    /**
     * тест проверяет, что при удалении несуществующего элемента массива
     * выбрасывается исключение
     */
    @Test(expected = OutOfSimpleArrayRangeException.class)
    public void deleteTheSecondElementTwoTimes() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        simplearr.delete(1);
        simplearr.delete(1);
    }

    /**
     * тест проверяет, что при удалении элемента массива
     * метод возвращает этот элемент
     */
    @Test
    public void deleteTheSecondElement() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        assertThat(simplearr.delete(0), is(1));
    }

    /**
     * тест проверяет, что метод update заменяет элемент
     */
    @Test
    public void updateTheSecondElement() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        simplearr.update(1, 3);
        assertThat(simplearr.get(1), is(3));
    }

    /**
     * тест проверяет, что при замене несуществующего элемента выбрасывается исключение
     */
    @Test(expected = OutOfSimpleArrayRangeException.class)
    public void updateTheThirdElement() {
        SimpleArray<Integer> simplearr = new SimpleArray<Integer>(2);
        simplearr.add(1);
        simplearr.add(2);
        simplearr.update(2, 3);
    }
}
