package ru.job4j.max;

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

public class MaxTest {
	/**
	* Test max(first, second).
	*/
    @Test
    public void whenCompareTwoAndOneThenTwo() {
        Max maximum = new Max();
        int result = maximum.max(2, 1);
        int expected = 2;
        assertThat(result, is(expected));
    }
	/**
	* Test max(first, second, third).
	*/
    @Test
    public void whenCompareTwoAndOneAndThreeThenTree() {
        Max maximum = new Max();
        int result = maximum.max(2, 1, 3);
        int expected = 3;
        assertThat(result, is(expected));
    }
}