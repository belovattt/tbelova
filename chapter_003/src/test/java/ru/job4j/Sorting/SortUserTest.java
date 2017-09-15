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
}
