package ru.job4j.list;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * класс для тестирования методов класса SimpleStack
 */
public class SimpleStackTest {
    /**
     * Тест для метода push
     * Добавляем два элемента в стек.
     * первый добавленный элемент стоит в списке вторым
     * второй - первым
     */
    @Test
    public void pushTwoElementsTest() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        assertThat(simpleStack.get(0), is(2));
        assertThat(simpleStack.get(1), is(1));
    }

    /**
     * тест для метода poll
     * добавляем два элемента в стек
     * первый вызов метода poll возвращает второй из добавленных элементов
     * второй вызов возвращает первый элемент
     * третий вызов генерирует исключение
     */
    @Test (expected = NoSuchElementException.class)
    public void pollThreeElementsTest() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
        simpleStack.poll();
    }
}
