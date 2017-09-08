package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;


/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConvertListTest {
    /**
     * Test for toArray.
     */
    @Test
    public void testToArrayWithZeroElements() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        int[][] result = new ConvertList().toArray(list, 3);
        int[][] expected = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 0, 0}};
        assertThat(result, is(expected));

    }

    /**
     * Test for toList.
     */
    @Test
    public void testToList() {
        List<Integer> expected = new ArrayList<Integer>();
        for (int i = 1; i <= 9; i++) {
            expected.add(i);
        }
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> result = new ConvertList().toList(array);
        assertThat(result, is(expected));

    }
    /**
     * Test for convert.
     */
    @Test
    public void testToConvert() {
        List<Integer> expected = new ArrayList<Integer>();
        for (int i = 1; i<=6; i++){
            expected.add(i);
        }
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});
        List<Integer> result = new ConvertList().convert(list);
        assertThat(result, is(expected));

    }


}