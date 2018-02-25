package ru.job4j.control;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CheckStringTest {

    @Test
    /**
     * если строки разной длины, метод вернет false
     */
    public void ifLengthVariousThenFalse() {
       CheckStrings checkStrings = new CheckStrings("1234", "12345");
        assertThat(checkStrings.check(), is(false));
    }

    @Test
    /**
     * если строки состоят из одних и тех же символов, метод вернет true
     */
    public void if11232And32211ThenTrue() {
        CheckStrings checkStrings = new CheckStrings("11232", "32211");
        assertThat(checkStrings.check(), is(true));
    }

    @Test
    /**
     * если строки состоят из разных символов, метод вернет false
     */
    public void if11232And12211ThenTrue() {
        CheckStrings checkStrings = new CheckStrings("11232", "12211");
        assertThat(checkStrings.check(), is(false));
    }
}
