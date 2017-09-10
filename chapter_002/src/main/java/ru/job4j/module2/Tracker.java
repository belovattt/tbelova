package ru.job4j.module2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Class Tracker решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 26.07.2017
*/
public class Tracker {
	/**
	*массив заявок.
	*/
	private ArrayList<Item> items = new ArrayList<Item>();

	/**
	*метод возвращает массив items.
	*@return items
	*/
	public ArrayList<Item> getItems() {
		return this.items;
	}
	/**
	*метод задает массив items.
	*@param items - items
	*/
	public void setItems(ArrayList<Item> items) {

		this.items = items;
	}

	/**
	*метод добавляет заявку.
	*@param item - добавляемая заявка
	*@return item
	*/
	public Item add(Item item) {
		this.items.add(item);
		return item;
	}
	/**
	*метод обновляет содержимое заявки.
	*@param item - добавляемая заявка
	*/
	public void update(Item item) {
		for (Item it: this.items) {
			if (it.getId().equals(item.getId())) {
				it.setName(item.getName());
				it.setDescription(item.getDescription());
				it.setCreated(System.currentTimeMillis());
				it.setComments(item.getComments());
				break;
				}
			}
	}
	/**
	*метод ищет заявку по ключу.
	*@param id - ключ
	*@return item
	*/
	public Item findById(String id) {
		Item item = null;
		for (Item it: this.items) {
			if (it.getId().equals(id)) {
				item = it;
				break;
			}
		}
		return item;
	}
	/**
	*метод ищет заявку по имени.
	*@param name - имя
	*@return finder
	*/
	public ArrayList<Item> findByName(String name) {
		ArrayList<Item> finder = new ArrayList<>();
		for (Item it: this.items) {
			if (it.getName().equals(name)) {
				finder.add(it);
			}
		}
		return finder;
	}
	/**
	*метод удаляет заявку по ключу.
	*@param id - ключ
	*/
	public void delete(String id) {
		for (Item it: this.items) {
			if (it.getId().equals(id)) {
				this.items.remove(it);
				break;
			}
		}


	}
	/**
	*метод возвращает список все заявок.
	*@return finder
	*/
	public ArrayList<Item> getAll() {

		return this.items;
	}
}