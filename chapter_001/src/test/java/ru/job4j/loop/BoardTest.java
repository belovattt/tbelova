package ru.job4j.loop;

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

public class BoardTest {
	/**
	* Test for board 3x3.
	*/
    @Test
    public void boardTreeTree() {
        Board board = new Board();
		String line = System.getProperty("line.separator");
        String result = board.paint(3, 3);
        String expected = String.format("x x%s x %sx x%s", line, line, line);
        assertThat(result, is(expected));
    }
	/**
	* Test for board 5x4.
	*/
    @Test
    public void boardFiveFour() {
        Board board = new Board();
		String line = System.getProperty("line.separator");
        String result = board.paint(5, 4);
        String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
        assertThat(result, is(expected));
    }
}