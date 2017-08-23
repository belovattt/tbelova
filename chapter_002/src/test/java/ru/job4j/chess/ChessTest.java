package ru.job4j.chess;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import ru.job4j.module2.Output;
import ru.job4j.module2.StubOutput;
import sun.security.krb5.internal.crypto.Des;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ChessTest {
    /**
     * Test for changind chessdesk after move. The first cell must be free.
     */
    @Test
    public void afterMoveTheFirstCellIsFree() {

        Input input = new StubInput(new String[]{"1", "1", "2", "2", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        assertTrue(desk.getChessdesk()[1][1].isFree());
    }
    /**
     * Test for changind chessdesk after move. The second cell must be busy.
     */
    @Test
    public void afterMoveTheTheSecondCellIsBusy() {

        Input input = new StubInput(new String[]{"1", "1", "2", "2", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        assertTrue(! desk.getChessdesk()[2][2].isFree());
    }
    /**
     * Test for changind chessdesk after move. The first cell hasn't figures.
     */
    @Test
    public void afterMoveTheFirstCellHasNoFigure() {

        Input input = new StubInput(new String[]{"1", "1", "2", "2", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        assertNull(desk.getChessdesk()[1][1].getFigure());
    }
    /**
     * Test for changind chessdesk after move. The second cell has figure.
     */
    @Test
    public void afterMoveTheTheSecondCellHasFigure() {

        Input input = new StubInput(new String[]{"1", "1", "2", "2", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        assertNotNull(desk.getChessdesk()[2][2].getFigure());
    }
    /**
     * Test for way of true move.
     */
    @Test
    public void afterMoveWeHaveTrueWay() {

        Input input = new StubInput(new String[]{"1", "1", "2", "2", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        String[] expected = {"1 1", "2 2"};
        assertThat(output.getLines(), is(expected));
    }
    /**
     * Test when the first cell is free.
     */
    @Test
    public void ifTheFirstCellIsFreeThenMistake() {

        Input input = new StubInput(new String[]{"2", "2", "3", "3", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        String[] expected = {"The first cell is empty"};
        assertThat(output.getLines(), is(expected));
    }
    /**
     * Test when the second cell is busy.
     */
    @Test
    public void ifTheSecondCellIsBusyThenMistake() {

        Input input = new StubInput(new String[]{"0", "0", "1", "1", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        String[] expected = {"The second cell is busy"};
        assertThat(output.getLines(), is(expected));
    }
    /**
     * Test when the move is impossible (elefants doesn't move like this).
     */
    @Test
    public void ifTheSecondCellIsWrongThenMistake() {

        Input input = new StubInput(new String[]{"1", "1", "2", "3", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        String[] expected = {"This way is wrong"};
        assertThat(output.getLines(), is(expected));
    }
    /**
     * Test when the move is impossible (elefants can not jump).
     */
    @Test
    public void ifTheWayIsBusyThenMistake() {

        Input input = new StubInput(new String[]{"0", "0", "3", "3", "y"});
        Output output = new StubOutput();
        Desk desk = new Desk();
        new Chess(desk, input, output).play();
        String[] expected = {"This way is wrong"};
        assertThat(output.getLines(), is(expected));
    }

}
