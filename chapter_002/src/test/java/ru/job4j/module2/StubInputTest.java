package ru.job4j.module2;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Tatyana Belova (mailto:belovatttt@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StubInputTest {
    /**
     * Test for adding new item.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "description", "comment", "y", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test name"));
    }

    /**
     * Test for show all items.
     */
    @Test
    public void whenUserAskShowAllItemsThenOutputAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setId("" + System.currentTimeMillis());
        item.setName("first");
        item.setDescription("first item");
        item.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item.setComments(comments);
        item = tracker.add(item);
        Input input = new StubInput(new String[]{"5", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        String[] expected = {"Item's name first", "Item's description first item", "Item was created " + item.getCreated(), "Item's id " + item.getId(), "Item's comments:", "comment1", "comment2"};
        assertThat(output.getLines(), is(expected));
    }

    /**
     * Test for update item.
     */
    @Test
    public void whenUserUpdateItemThenItemHasNewName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId("" + System.currentTimeMillis());
        item1.setName("first");
        item1.setDescription("first item");
        item1.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item1.setComments(comments);
        item1 = tracker.add(item1);
        Input input = new StubInput(new String[]{"2", item1.getId(), "new name", "new description", "new comments", "y", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("new name"));
    }

    /**
     * Test for delete item.
     */
    @Test
    public void whenUserAskDeleteSecondItemThenTrackerDeleteIt() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId("1" + System.currentTimeMillis());
        item1.setName("first");
        item1.setDescription("first item");
        item1.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item1.setComments(comments);
        Item item2 = new Item();
        item2.setId("2" + System.currentTimeMillis());
        item2.setName("second");
        item2.setDescription("second item");
        item2.setCreated(System.currentTimeMillis());
        item2.setComments(comments);
        Item item3 = new Item();
        item3.setId("3" + System.currentTimeMillis());
        item3.setName("third");
        item3.setDescription("third item");
        item3.setCreated(System.currentTimeMillis());
        item3.setComments(comments);
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        item3 = tracker.add(item3);
        Input input = new StubInput(new String[]{"3", item2.getId(), "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item3);
        assertThat(tracker.getAll(), is(expected));
    }

    /**
     * Test for find by id.
     */
    @Test
    public void whenUserAskItem2IdThenOutputItem2() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId("1" + System.currentTimeMillis());
        item1.setName("first");
        item1.setDescription("first item");
        item1.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item1.setComments(comments);
        Item item2 = new Item();
        item2.setId("2" + System.currentTimeMillis());
        item2.setName("second");
        item2.setDescription("second item");
        item2.setCreated(System.currentTimeMillis());
        item2.setComments(comments);
        Item item3 = new Item();
        item3.setId("3" + System.currentTimeMillis());
        item3.setName("third");
        item3.setDescription("third item");
        item3.setCreated(System.currentTimeMillis());
        item3.setComments(comments);
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        item3 = tracker.add(item3);
        Input input = new StubInput(new String[]{"1", item2.getId(), "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        String[] expected = {"Item's name " + item2.getName(), "Item's description " + item2.getDescription(), "Item was created " + item2.getCreated(), "Item's id " + item2.getId(), "Item's comments:", "comment1", "comment2"};
        assertThat(output.getLines(), is(expected));
    }

    /**
     * Test for find by name.
     */
    @Test
    public void whenUserAskItem1NameThenOutputItem1AndItem3() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId("1" + System.currentTimeMillis());
        item1.setName("first");
        item1.setDescription("first item");
        item1.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item1.setComments(comments);
        Item item2 = new Item();
        item2.setId("2" + System.currentTimeMillis());
        item2.setName("second");
        item2.setDescription("second item");
        item2.setCreated(System.currentTimeMillis());
        item2.setComments(comments);
        Item item3 = new Item();
        item3.setId("3" + System.currentTimeMillis());
        item3.setName("first");
        item3.setDescription("third item");
        item3.setCreated(System.currentTimeMillis());
        item3.setComments(comments);
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        item3 = tracker.add(item3);
        Input input = new StubInput(new String[]{"4", item1.getName(), "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        String[] expected = {"Item's name " + item1.getName(), "Item's description " + item1.getDescription(), "Item was created " + item1.getCreated(), "Item's id " + item1.getId(), "Item's comments:", "comment1", "comment2", "Item's name " + item3.getName(), "Item's description " + item3.getDescription(), "Item was created " + item3.getCreated(), "Item's id " + item3.getId(), "Item's comments:", "comment1", "comment2"};
        assertThat(output.getLines(), is(expected));
    }

    /**
     * Test incorrect menu value.
     */
    @Test
    public void whenUserEnterIncorrectValueThenMistakeUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new ValidateInputForTest(new String[]{"10", "0", "test name", "description", "comment", "y", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        assertThat(input.getOutputWrite()[0] + tracker.getAll().get(0).getName(), is("Please enter number between 0 and 5" + "test name"));
    }

    /**
     * Test incorrect data value.
     */
    @Test
    public void whenUserEnterNotANumberThenMistakeUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new ValidateInputForTest(new String[]{"a", "0", "test name", "description", "comment", "y", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        assertThat(input.getOutputWrite()[0] + tracker.getAll().get(0).getName(), is("Please enter correct data" + "test name"));
    }

    /**
     * Test for incorrect id.
     */
    @Test
    public void whenUserUpdateItemWithIncorrectIdThenMessage() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId("" + System.currentTimeMillis());
        item1.setName("first");
        item1.setDescription("first item");
        item1.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item1.setComments(comments);
        item1 = tracker.add(item1);
        Input input = new ValidateInputForTest(new String[]{"2", "qwe", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        assertThat(output.getLines()[0], is("Item doesn't exist"));
    }

    /**
     * Test for wrong delete.
     */
    @Test
    public void whenUserAskDeleteNonexistingItemThenMistake() {
        Tracker tracker = new Tracker();
        Item item1 = new Item();
        item1.setId("1" + System.currentTimeMillis());
        item1.setName("first");
        item1.setDescription("first item");
        item1.setCreated(System.currentTimeMillis());
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("comment1");
        comments.add("comment2");
        item1.setComments(comments);
        Item item2 = new Item();
        item2.setId("2" + System.currentTimeMillis());
        item2.setName("second");
        item2.setDescription("second item");
        item2.setCreated(System.currentTimeMillis());
        item2.setComments(comments);
        Item item3 = new Item();
        item3.setId("3" + System.currentTimeMillis());
        item3.setName("third");
        item3.setDescription("third item");
        item3.setCreated(System.currentTimeMillis());
        item3.setComments(comments);
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        item3 = tracker.add(item3);
        Input input = new ValidateInputForTest(new String[]{"3", "123", "y"});
        Output output = new StubOutput();
        new StartUI(input, output, tracker).init();
        assertThat(output.getLines()[0], is("Item doesn't exist"));
    }
}