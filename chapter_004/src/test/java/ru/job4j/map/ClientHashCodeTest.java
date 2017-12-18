package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ClientHashCodeTest {
    /**
     * если объект не менялся, повторный вызов метода возвращает тот же hashcode
     */
@Test
public void objectHasOneHashcode() {
    Client cl = new Client("Tom", 34, 105.6);
    assertThat(cl.hashCode() == cl.hashCode(), is(true));
}
    /**
     * равные объекты имеют один hashcode
     */
    @Test
    public void ifCl1EqualsCl2ThenHashcode1EqualsHashCode2() {
        Client cl1 = new Client("Tom", 34, 105.6);
        Client cl2 = new Client("Tom", 34, 105.6);
        assertThat(cl1.hashCode() == cl2.hashCode(), is(true));
    }
}
