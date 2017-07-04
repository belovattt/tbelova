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

public class TurnTest {
	/**
	* Test for even length.
	*/
    @Test
    public void evenLength() {
        Turn turn = new Turn();
		int[] array = {4, 1, 6, 2};
        int[] result = turn.back(array);
        int[] expected = {2, 6, 1, 4};
        assertThat(result, is(expected));
    }
	/**
	* Test for odd length.
	*/
    @Test
    public void oddLength() {
        Turn turn = new Turn();
		int[] array = {1, 2, 3, 4, 5};
        int[] result = turn.back(array);
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}