package ru.job4j.shapes;

/**
 * Класс Square для рисования прямоугольника.
 */
public class Square implements Shape {
    /**
     * Метод составляет строку для рисования прямоугольника.
     *
     * @return строка
     */
    public String pic() {
        String sep = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder("*****");
        for (int i = 1; i <= 3; i++) {
            s.append(sep);
            s.append("*   *");
        }
        s.append(sep);
        s.append("*****");
        return s.toString();
    }
}
