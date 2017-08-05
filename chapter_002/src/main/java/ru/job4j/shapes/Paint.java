package ru.job4j.shapes;

import ru.job4j.module2.Output;

/**
 * Класс Paint для рисования фигуры.
 */
public class Paint {
    /**
     * Вывод.
     */
    private Output output;
    /**
     * Фигура.
     */
    private Shape shape;

    /**
     * Конструктор.
     *
     * @param shape  - фигура
     * @param output - вывод
     */
    Paint(Shape shape, Output output) {
        this.shape = shape;
        this.output = output;
    }

    /**
     * Способ вывода данных.
     *
     * @param output - вывод
     */
    public void setOutput(Output output) {
        this.output = output;
    }

    /**
     * Метод выводит заданную фигуру.
     */
    public void draw() {
        this.output.write(this.shape.pic());
    }
}
