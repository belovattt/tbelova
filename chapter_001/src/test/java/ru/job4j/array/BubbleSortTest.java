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

public class BubbleSortTest {
	/**
	* Test.
	*/
    @Test
    public void sortTest() {
        BubbleSort bubble = new BubbleSort();
		int[] array = {5, 1, 2, 7, 3};
        int[] result = bubble.sort(array);
        int[] expected = {1, 2, 3, 5, 7};
        assertThat(result, is(expected));
    }
}