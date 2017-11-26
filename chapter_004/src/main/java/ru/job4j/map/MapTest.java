package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {
    /**
     * тест выводит содержимое карты.
     * если в качестве ключа использованы объекты
     * одного класса, с одинаковыми полями,
     * методы hashCode и equals не переопределены
     */
    @Test
    public void whenNotOverrideEquals() {
        Calendar c = new GregorianCalendar(2017, 11, 21);
        User user1 = new User("Vasya", 2, c);
        User user2 = new User("Vasya", 2, c);
        Map map = new HashMap<User, Object>();
        map.put(user1, "qqq");
        map.put(user2, "aaa");
        System.out.println(map);
    }
}
