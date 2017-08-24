package ru.job4j.ATM;
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
public class ATMTest {
    /**
     * Test for true answer.
     */
    @Test
    public void cashIsTenBondsAreFiveTreeOne() {
        int[] bonds = {5, 3, 1};
        int cash = 10;
        Money money = new Money(bonds, cash);
        money.init();
        String result = money.getAnswer();
        String expected = "55 5311 511111 3331 331111 31111111 1111111111 ";
        assertThat(result, is(expected));

    }

}
