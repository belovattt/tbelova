package ru.job4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class UserConvertTest {
    /**
     * Test for process.
     */
    @Test
    public void testProcess() {
        HashMap<Integer, User> expected = new HashMap<>();
        List<User> list = new ArrayList<User>();
        User user = new User(1, "Mike", "London");
        expected.put(user.getId(), user);
        list.add(user);
        user = new User(2, "Tom", "Rome");
        expected.put(user.getId(), user);
        list.add(user);
        HashMap<Integer, User> result = new UserConvert().process(list);
        assertThat(result, is(expected));

    }

}
