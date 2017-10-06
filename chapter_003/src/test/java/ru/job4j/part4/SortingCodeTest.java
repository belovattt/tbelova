package ru.job4j.part4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortingCodeTest {
    /**
     * Test for sortingAscending.
     */
    @Test
    public void sortingAscendingTest() {
        String[] spisok = {"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        ArrayList<String> list = new ArrayList<>();
        for (String s: spisok) {
            list.add(s);
        }
        TreeSet<String> tree = new SortingCodes().sortingAscending(list);
        StringBuffer result = new StringBuffer();
        for (String s: tree) {
            result.append(s + " ");
        }
        assertThat(result.toString(), is("K1 K1/SK1 K1/SK1/SSK1 K1/SK1/SSK2 K1/SK2 K2 K2/SK1 K2/SK1/SSK1 K2/SK1/SSK2 "));
    }
    /**
     * Test for sortingDescending.
     */
    @Test
    public void sortingDescendingTest() {
        String[] spisok = {"K1/SK1", "K1/SK2", "K1/SK1/SSK1", "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};
        ArrayList<String> list = new ArrayList<>();
        for (String s: spisok) {
            list.add(s);
        }
        TreeSet<String> tree = new SortingCodes().sortingDescending(list);
        StringBuffer result = new StringBuffer();
        for (String s: tree) {
            result.append(s + " ");
        }
        assertThat(result.toString(), is("K2 K2/SK1 K2/SK1/SSK2 K2/SK1/SSK1 K1 K1/SK2 K1/SK1 K1/SK1/SSK2 K1/SK1/SSK1 "));
    }

}
