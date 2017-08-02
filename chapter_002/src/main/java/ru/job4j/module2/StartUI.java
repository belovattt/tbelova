package ru.job4j.module2;

import java.util.Arrays;

/**
 *Class StartUI решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 26.07.2017
*/
public class StartUI {
	/**
	*добавление заявки.
	*/
	private static final int ADD = 0;
	/**
	*получить список заявок.
	*/
	private static final int GETALL = 1;
	/**
	*изменить заявку.
	*/
	private static final int UPDATE = 2;
	/**
	*удалить заявку.
	*/
	private static final int DELETE = 3;
	/**
	*найти заявку по id.
	*/
	private static final int FINDBYID = 4;
	/**
	*найти заявки по имени.
	*/
	private static final int FINDBYNAME = 5;
	/**
	*выход.
	*/
	private static final int EXIT = 6;
	/**
	*ввод данных.
	*/
	private Input input;
	/**
	*вывод данных.
	*/
	private Output output;
	/**
	*tracker.
	*/
	private Tracker tracker;
	/**
	*конструктор.
	*@param input - ввод данных
	*@param output - вывод данных
	*@param tracker - tracker
	*/
	public StartUI(Input input, Output output, Tracker tracker) {
		this.input = input;
		this.output = output;
		this.tracker = tracker;
	}
	/**
	*метод init.
	*/
	public void init() {
		int choice;
		do {
			this.showMenu();
			choice = Integer.parseInt(input.ask("Enter your choice "));
			switch (choice) {
				case ADD:
				this.showItem(tracker.add(this.addNewItem()));
				break;
				case GETALL:
					this.showItems(tracker.getAll());
					break;
				case UPDATE:
					tracker.update(this.editItem());
					break;
				case DELETE:
					tracker.delete(input.ask("Please, enter item's id "));
					break;
				case FINDBYID:
					this.showItem(tracker.findById(input.ask("Please, enter item's id ")));
					break;
				case FINDBYNAME:
					this.showItems(tracker.findByName(input.ask("Please, enter item's name ")));
					break;
				default:
			}
		} while (choice != EXIT);
	}
	/**
	*метод main.
	*@param args - args
	*/
	public static void main(String[] args) {
		Input input = new ConsoleInput();
		Output output = new ConsoleOutput();
		Tracker tracker = new Tracker();
		new StartUI(input, output, tracker).init();
	}
	/**
	*метод выводит на экран меню.
	*/
	private void showMenu() {
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
	private Item addNewItem() {
		Item item = new Item();
		item.setName(input.ask("Input item's name "));
		item.setDescription(input.ask("Input item's description "));
		item.setCreated(System.currentTimeMillis());
		item.setId("" + System.currentTimeMillis());
		String[] forcomments = new String[10];
		int i = 0;
		String end;
		do {
			forcomments[i++] = input.ask("Input item's comment ");
			end = input.ask("Is it all? (y/n) ");
		} while (end.equals("n"));
		item.setComments(Arrays.copyOf(forcomments, i));
		return item;
	}
	/**
	*метод выводит на экран поля заявки.
	*@param item - item
	*/
	private void showItem(Item item) {
		this.output.write("Item's name " + item.getName());
		this.output.write("Item's description " + item.getDescription());
		this.output.write("Item was created " + item.getCreated());
		this.output.write("Item's id " + item.getId());
		this.output.write("Item's comments:");
		for (String s : item.getComments()) {
			this.output.write(s);
		}
	}
	/**
	*метод выводит на экран все заявки из массива.
	*@param items - массив заявок
	*/
	private void showItems(Item[] items) {
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
	private Item editItem() {
		Item item = new Item();
		item.setId(input.ask("Please, enter item's id "));
		item.setName(input.ask("Input item's new name "));
		item.setDescription(input.ask("Input item's new description "));
		item.setCreated(System.currentTimeMillis());
		String[] forcomments = new String[10];
		int i = 0;
		String end;
		do {
			forcomments[i++] = input.ask("Input item's new comment ");
			end = input.ask("Is it all? (y/n) ");
		} while (end.equals("n"));
		item.setComments(Arrays.copyOf(forcomments, i));
		return item;
	}
}