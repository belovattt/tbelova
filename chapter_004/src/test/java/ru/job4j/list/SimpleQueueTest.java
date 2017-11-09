package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * класс для тестирования методов класса SimpleStack
 */

public class SimpleQueueTest {
    /**
     * Тест для метода push
     * Добавляем два элемента в очередь.
     * первый добавленный элемент стоит в списке первым
     * второй - вторым
     */
    @Test
    public void pushTwoElementsTest() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        assertThat(simpleQueue.get(0), is(1));
        assertThat(simpleQueue.get(1), is(2));
    }

    /**
     * тест для метода poll
     * добавляем два элемента в очередь
     * первый вызов метода poll возвращает первый из добавленных элементов
     * второй вызов возвращает второй элемент
     * третий вызов генерирует исключение
     */
    @Test (expected = NoSuchElementException.class)
    public void pollThreeElementsTest() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        simpleQueue.push(1);
        simpleQueue.push(2);
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        simpleQueue.poll();
    }
}
