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

public class ArrayDuplicateTest {
	/**
	* Test.
	*/
    @Test
    public void dulicateTest() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
		String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
		String[] result = duplicate.remove(array);
        String[] expected = {"Привет", "Мир", "Супер"};
        assertThat(result, is(expected));
    }
}