package ru.job4j.module2;

import java.util.Arrays;

/**
 *Class Tracker решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 26.07.2017
*/
public class StartUI {
	/**
	*метод main.
	*@param args - args
	*/
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		ConsoleInput console = new ConsoleInput();
		int choice;
		do {
			showMenu();
			choice = Integer.parseInt(console.ask("Enter your choice "));
			switch (choice) {
				case 0:
				showItem(tracker.add(addNewItem()));
				break;
				case 1:
					showItems(tracker.getAll());
					break;
				case 2:
					tracker.update(editItem());
					break;
				case 3:
					tracker.delete(console.ask("Please, enter item's id "));
					break;
				case 4:
					showItem(tracker.findById(console.ask("Please, enter item's id ")));
					break;
				case 5:
					showItems(tracker.findByName(console.ask("Please, enter item's name ")));
					break;
				default:
			}
		} while (choice != 6);
	}
	/**
	*метод выводит на экран меню.
	*/
	static void showMenu() {
		System.out.println("0. Add new item.");
		System.out.println("1. Show all items.");
		System.out.println("2. Edit item.");
		System.out.println("3. Delete item.");
		System.out.println("4. Find item by Id.");
		System.out.println("5. Find items by name.");
		System.out.println("6. Exit program.");
	}
	/**
	*метод опрашивает пользователя и заполняет поля заявки.
	*@return item - заявка
	*/
	static Item addNewItem() {
		ConsoleInput consoleInput = new ConsoleInput();
		Item item = new Item();
		item.setName(consoleInput.ask("Input item's name "));
		item.setDescription(consoleInput.ask("Input item's description "));
		item.setCreated(System.currentTimeMillis());
		item.setId("" + System.currentTimeMillis());
		String[] forcomments = new String[10];
		int i = 0;
		String end;
		do {
			forcomments[i++] = consoleInput.ask("Input item's comment ");
			end = consoleInput.ask("Is it all? (y/n) ");
		} while (end.equals("n"));
		item.setComments(Arrays.copyOf(forcomments, i));
		return item;
	}
	/**
	*метод выводит на экран поля заявки.
	*@param item - item
	*/
	static void showItem(Item item) {
		System.out.println("Item's name " + item.getName());
		System.out.println("Item's description " + item.getDescription());
		System.out.println("Item was created " + item.getCreated());
		System.out.println("Item's id " + item.getId());
		System.out.println("Item's comments:");
		for (String s : item.getComments()) {
			System.out.println(s);
		}
	}
	/**
	*метод выводит на экран все заявки из массива.
	*@param items - массив заявок
	*/
	static void showItems(Item[] items) {
		System.out.println("Items:");
		for (int i = 0; i < items.length; i++) {
			showItem(items[i]);
			System.out.println("");
		}
	}
	/**
	*метод редактирует заявку.
	*@return item - измененная заявка
	*/
	static Item editItem() {
		Item item = new Item();
		ConsoleInput consoleInput = new ConsoleInput();
		item.setId(consoleInput.ask("Please, enter item's id "));
		item.setName(consoleInput.ask("Input item's new name "));
		item.setDescription(consoleInput.ask("Input item's new description "));
		item.setCreated(System.currentTimeMillis());
		String[] forcomments = new String[10];
		int i = 0;
		String end;
		do {
			forcomments[i++] = consoleInput.ask("Input item's new comment ");
			end = consoleInput.ask("Is it all? (y/n) ");
		} while (end.equals("n"));
		item.setComments(Arrays.copyOf(forcomments, i));
		return item;
	}
}