package ru.job4j.module2;

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

public class TrackerTest {
	/**
	* Test for add method for return item.
	*/
    @Test
	public void addOneElementTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
		item1.setComments(comments);
		Item result = tracker.add(item1);
		assertThat(result, is(item1));
	}
	/**
	* Test for add method for items was changed.
	*/
    @Test
	 public void addThreeElementsTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("1" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
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
		Item item = tracker.add(item1);
		item = tracker.add(item2);
		item = tracker.add(item3);
		Item[] result = tracker.getItems();
        Item[] expected = new Item[100];
		expected[0] = item1;
		expected[1] = item2;
		expected[2] = item3;
        assertThat(result, is(expected));
    }
	/**
	* Test for update method.
	*/
    @Test
	public void updateSecondItemTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("1" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
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
		Item[] expected = new Item[100];
		expected[0] = item1;
		expected[1] = item2;
		expected[2] = item3;
		tracker.setItems(expected);
		tracker.setIndex(3);
		item2.setName("new second");
		item2.setDescription("new second item");
		item2.setCreated(System.currentTimeMillis());
		String[] newcomments = {"comment1", "comment2", "comment3"};
		item2.setComments(newcomments);
		tracker.update(item2);
		expected[1] = item2;
		Item[] result = tracker.getItems();
		assertThat(result, is(expected));
	}
	/**
	* Test for findById method.
	*/
    @Test
	public void findByIdSecondItemTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("1" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
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
		Item[] items = new Item[100];
		items[0] = item1;
		items[1] = item2;
		items[2] = item3;
		tracker.setItems(items);
		tracker.setIndex(3);
		Item result = tracker.findById(item2.getId());
		Item expected = items[1];
		assertThat(result, is(expected));
	}
	/**
	* Test for findByName method.
	*/
    @Test
	public void findByNameSecondItemTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("1" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
		item1.setComments(comments);
		Item item2 = new Item();
		item2.setId("2" + System.currentTimeMillis());
		item2.setName("second");
		item2.setDescription("second item");
		item2.setCreated(System.currentTimeMillis());
		item2.setComments(comments);
		Item item3 = new Item();
		item3.setId("3" + System.currentTimeMillis());
		item3.setName("second");
		item3.setDescription("third item");
		item3.setCreated(System.currentTimeMillis());
		item3.setComments(comments);
		Item[] items = new Item[100];
		items[0] = item1;
		items[1] = item2;
		items[2] = item3;
		tracker.setItems(items);
		tracker.setIndex(3);
		Item[] result = tracker.findByName("second");
		Item[] expected = {item2, item3};
		assertThat(result, is(expected));
	}
	/**
	* Test for delete method.
	*/
    @Test
	public void deleteSecondItemTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("1" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
		item1.setComments(comments);
		Item item2 = new Item();
		item2.setId("2" + System.currentTimeMillis());
		item2.setName("second");
		item2.setDescription("second item");
		item2.setCreated(System.currentTimeMillis());
		item2.setComments(comments);
		Item item3 = new Item();
		item3.setId("3" + System.currentTimeMillis());
		item3.setName("second");
		item3.setDescription("third item");
		item3.setCreated(System.currentTimeMillis());
		item3.setComments(comments);
		Item[] items = new Item[100];
		items[0] = item1;
		items[1] = item2;
		items[2] = item3;
		tracker.setItems(items);
		tracker.setIndex(3);
		tracker.delete(item2.getId());
		Item[] result = tracker.getItems();
		Item[] expected = new Item[100];
		expected[0] = item1;
		expected[1] = item3;
		assertThat(result, is(expected));
	}
	/**
	* Test for getAll method.
	*/
    @Test
	public void getAllThreeItemsTest() {
		Tracker tracker = new Tracker();
        Item item1 = new Item();
		item1.setId("1" + System.currentTimeMillis());
		item1.setName("first");
		item1.setDescription("first item");
		item1.setCreated(System.currentTimeMillis());
		String[] comments = {"comment1", "comment2"};
		item1.setComments(comments);
		Item item2 = new Item();
		item2.setId("2" + System.currentTimeMillis());
		item2.setName("second");
		item2.setDescription("second item");
		item2.setCreated(System.currentTimeMillis());
		item2.setComments(comments);
		Item item3 = new Item();
		item3.setId("3" + System.currentTimeMillis());
		item3.setName("second");
		item3.setDescription("third item");
		item3.setCreated(System.currentTimeMillis());
		item3.setComments(comments);
		Item[] items = new Item[100];
		items[0] = item1;
		items[1] = item2;
		items[2] = item3;
		tracker.setItems(items);
		tracker.setIndex(3);
		Item[] result = tracker.getAll();
		Item[] expected = {item1, item2, item3};
		assertThat(result, is(expected));
	}
}