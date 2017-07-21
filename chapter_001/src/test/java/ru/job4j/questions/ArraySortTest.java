package ru.job4j.questions;

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

public class ArraySortTest {
	/**
	* Test.
	*/
    @Test
    public void sequencingTest() {
        ArraySort arraySort = new ArraySort();
		int[] array1 = {1, 3, 4, 5, 7};
		int[] array2 = {1, 2, 6, 8};
		int[] result = arraySort.sequencing(array1, array2);
        int[] expected = {1, 1, 2, 3, 4, 5, 6, 7, 8};
        assertThat(result, is(expected));
    }
}