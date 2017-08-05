package ru.job4j.shapes;

import ru.job4j.module2.Output;
import ru.job4j.module2.StubOutput;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Класс PaintTest для тестирования рисования фигуры.
 */
public class PaintTest {
    /**
     * Треугольник.
     */
    @Test
    public void triangleTest() {
        Output output = new StubOutput();
        new Paint(new Triangle(), output).draw();
        String[] result = output.getLines();
        String line = System.getProperty("line.separator");
        String[] expected = {String.format("  *  %s *** %s*****", line, line)};
        assertThat(result, is(expected));
    }
    /**
     * Квадрат.
     */
    @Test
    public void squareTest() {
        Output output = new StubOutput();
        new Paint(new Square(), output).draw();
        String[] result = output.getLines();
        String line = System.getProperty("line.separator");
        String[] expected = {String.format("*****%s*   *%s*   *%s*   *%s*****", line, line, line, line)};
        assertThat(result, is(expected));
    }
}
