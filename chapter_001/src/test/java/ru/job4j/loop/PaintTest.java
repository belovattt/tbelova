package ru.job4j.loop;

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

public class PaintTest {
	/**
	* Test for h = 2.
	*/
    @Test
    public void hTwo() {
        Paint paint = new Paint();
		String line = System.getProperty("line.separator");
        String result = paint.piramid(2);
        String expected = String.format(" ^%s^^^%s", line, line);
        assertThat(result, is(expected));
    }
	/**
	* Test for h = 3.
	*/
    @Test
    public void hThree() {
        Paint paint = new Paint();
		String line = System.getProperty("line.separator");
        String result = paint.piramid(3);
        String expected = String.format("  ^%s ^^^%s^^^^^%s", line, line, line);
        assertThat(result, is(expected));
    }
}