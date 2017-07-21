package ru.job4j.questions;;

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

public class TestOfStringTest {
	/**
	* Test true answer.
	*/
    @Test
    public void ifPrivetAndRivThenTrue() {
        TestOfString test = new TestOfString();
		String origin = "privet";
		String sub = "riv";
        boolean result = test.contains(origin, sub);
        boolean expected = true;
        assertThat(result, is(expected));
    }
	/**
	* Test false answer.
	*/
    @Test
    public void ifPrivetAndRasThenFalse() {
        TestOfString test = new TestOfString();
		String origin = "privet";
		String sub = "pos";
        boolean result = test.contains(origin, sub);
        boolean expected = false;
        assertThat(result, is(expected));
    }
}