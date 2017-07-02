package ru.job4j.condition;

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

public class PointTest {
	/**
	* Test condition.
	*/
    @Test
    public void whenPointIsOnLineThenTrue() {
        Point point = new Point(1, 3);
        boolean result = point.is(2, 1);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}