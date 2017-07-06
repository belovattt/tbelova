package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Tatyana Belova (mailto:belovatttt@gmail.com)
* @version $Id$
* @since 0.1
*/

public class RotateArrayTest {
	/**
	* Test матрица 2х2.
	*/
    @Test
    public void rotateTwoDimentionTest() {
        RotateArray rotation = new RotateArray();
		int[][] array = {{1, 2}, {3, 4}};
        int[][] result = rotation.rotate(array);
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(result, is(expected));
    }
	/**
	* Test матрица 3х3.
	*/
    @Test
    public void rotateThreeDimentionTest() {
        RotateArray rotation = new RotateArray();
		int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = rotation.rotate(array);
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(result, is(expected));
    }
}