package ru.job4j.shapes;

/**
 * Класс Triangle для рисования треугольника.
 */

public class Triangle implements Shape {
    /**
     * Метод составляет строку для рисования треугольника.
     *
     * @return строка
     */
    public String pic() {
        String sep = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder("  *  ");
        s.append(sep);
        s.append(" *** ");
        s.append(sep);
        s.append("*****");
        return s.toString();
    }
}
