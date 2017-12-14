package ru.job4j.map;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ClientEqualsTest {
    /**
     * рефлексивность.
     */
    @Test
    public void ifClEqualsClThenTrue() {
        Client cl = new Client("Tom", 34, 105.6);
        assertThat(cl.equals(cl), is(true));
    }
    /**
     * симметричность
     */
    @Test
    public void ifCl1EqualsCl2ThenCl2EqualsCl1() {
        Client cl1 = new Client("Tom", 34, 105.6);
        Object cl2 = cl1;
        Object cl3 = new Client("Nick", 15, 99.6);
        assertThat((cl1.equals(cl2) == cl2.equals(cl1)) && (cl1.equals(cl3) == cl3.equals(cl1)), is(true));
    }
    /**
     * транзитивность
     */
    @Test
    public void ifCl1EqualsCl2AndCl2EqualsCl3ThenCl1EqualsCl3() {
        Client cl1 = new Client("Tom", 34, 105.6);
        Object cl2 = cl1;
        Client cl3 = new Client("Tom", 34, 105.6);
        assertThat(cl1.equals(cl2) && cl2.equals(cl3) && cl1.equals(cl3), is(true));
    }
    /**
     * непротиворечивость
     */
    @Test
    public void ifCl1EqualsCl2ThenCl1EqualsCl2() {
        Client cl1 = new Client("Tom", 34, 105.6);
        Object cl2 = cl1;
        Object cl3 = new Client("Nick", 15, 99.6);
        assertThat((cl1.equals(cl2) == cl1.equals(cl2)) && (cl1.equals(cl3) == cl1.equals(cl3)), is(true));
    }
}
