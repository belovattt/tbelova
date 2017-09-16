package ru.job4j.Sorting;

import org.junit.Test;
import ru.job4j.ConvertList;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortUserTest {
    /**
     * Test for sort.
     */
    @Test
    public void testSort() {
        List<User> list = new ArrayList<User>();
        list.add(new User("Mike", 24));
        list.add(new User("Tom", 15));
        list.add(new User("Ann", 24));
        Set<User> set = new SortUser().sort(list);
        StringBuffer result = new StringBuffer();
        for (User user : set) {
            result.append(user.toString());
        }
        assertThat(result.toString(), is("Tom15Ann24Mike24"));
    }
    /**
     * Test for sortNameLength.
     */
    @Test
    public void testSortNameLength() {
        List<User> list = new ArrayList<User>();
        list.add(new User("Mike", 24));
        list.add(new User("Tomas", 15));
        list.add(new User("Ann", 24));
        List<User> res = new SortUser().sortNameLength(list);
        List<User> expected = new ArrayList<User>();
        StringBuffer result = new StringBuffer();
        for (User user : res) {
            result.append(user.toString());
        }
        assertThat(result.toString(), is("Ann24Mike24Tomas15"));
    }
    /**
     * Test for sortByAllFields.
     */
    @Test
    public void testSortByAllFields() {
        List<User> list = new ArrayList<User>();
        list.add(new User("Сергей", 25));
        list.add(new User("Иван", 30));
        list.add(new User("Сергей", 20));
        list.add(new User("Иван", 25));
        List<User> res = new SortUser().sortByAllFields(list);
        List<User> expected = new ArrayList<User>();
        StringBuffer result = new StringBuffer();
        for (User user : res) {
            result.append(user.toString());
        }
        assertThat(result.toString(), is("Иван25Иван30Сергей20Сергей25"));
    }
}
