package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* Test.
*
* @author Tatyana Belova (mailto:belovatttt@gmail.com)
* @version $Id$
* @since 0.1
*/

public class TriangleTest {
	/**
	* Test треугольник существует, вычисляем площадь.
	*/
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
		Point a = new Point(0, 0);
		Point b = new Point(0, 2);
		Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
		double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
 }
 /**
	* Test треугольник не существует, возвращаем -1.
	*/
    @Test
    public void whenTriangleDoesntExistThenMinusOne() {
		Point a = new Point(0, 0);
		Point b = new Point(0, 2);
		Point c = new Point(0, 1);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
		double expected = -1D;
        assertThat(result, closeTo(expected, 0.1));
 }
}