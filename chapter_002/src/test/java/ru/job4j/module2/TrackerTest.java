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
		ArrayList<String> comments = new ArrayList<String>();
		comments.add("comment1");
		comments.add("comment2");
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
		Item item = tracker.add(item1);
		item = tracker.add(item2);
		item = tracker.add(item3);
		ArrayList<Item> result = tracker.getItems();
		ArrayList<Item> expected = new ArrayList<Item>();
		expected.add(item1);
		expected.add(item2);
		expected.add(item3);
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
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
		tracker.setItems(expected);
		item2.setName("new second");
		item2.setDescription("new second item");
		item2.setCreated(System.currentTimeMillis());
        ArrayList<String> newcomments = new ArrayList<String>();
        newcomments.add("comment1");
        newcomments.add("comment2");
        newcomments.add("comment3");
		item2.setComments(newcomments);
		tracker.update(item2);
		expected.add(1, item2);
		ArrayList<Item> result = tracker.getItems();
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
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		tracker.setItems(items);
		Item result = tracker.findById(item2.getId());
		Item expected = items.get(1);
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
		item3.setName("second");
		item3.setDescription("third item");
		item3.setCreated(System.currentTimeMillis());
		item3.setComments(comments);
		ArrayList<Item> items = new ArrayList<>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		tracker.setItems(items);
		ArrayList<Item> result = tracker.findByName("second");
		ArrayList<Item> expected = new ArrayList<>();
		expected.add(item2);
		expected.add(item3);
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
		item3.setName("second");
		item3.setDescription("third item");
		item3.setCreated(System.currentTimeMillis());
		item3.setComments(comments);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		tracker.setItems(items);
		tracker.delete(item2.getId());
		ArrayList<Item> result = tracker.getItems();
		ArrayList<Item> expected = new ArrayList<>();
		expected.add(item1);
		expected.add(item3);
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
		item3.setName("second");
		item3.setDescription("third item");
		item3.setCreated(System.currentTimeMillis());
		item3.setComments(comments);
		ArrayList<Item> items = new ArrayList<>();;
		items.add(item1);
		items.add(item2);
		items.add(item3);
		tracker.setItems(items);
		ArrayList<Item> result = tracker.getAll();
        ArrayList<Item> expected = items;
		assertThat(result, is(expected));
	}
}