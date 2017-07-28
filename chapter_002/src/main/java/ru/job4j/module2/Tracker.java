package ru.job4j.module2;

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
	private Item[] items = new Item[100];
	/**
	*номер первой пустой заявки.
	*/
	private int index = 0;
	/**
	*метод возвращает массив items.
	*@return items
	*/
	public Item[] getItems() {
		return this.items;
	}
	/**
	*метод задает массив items.
	*@param items - items
	*/
	public void setItems(Item[] items) {
		this.items = items;
	}
	/**
	*метод задает номер первой пустой заявки.
	*@param index - index
	*/
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	*метод добавляет заявку.
	*@param item - добавляемая заявка
	*@return item
	*/
	public Item add(Item item) {
		this.items[this.index] = item;
		this.index++;
		return item;
	}
	/**
	*метод обновляет содержимое заявки.
	*@param item - добавляемая заявка
	*/
	public void update(Item item) {
		for (int i = 0; i < this.index; i++) {
			if (this.items[i].getId().equals(item.getId())) {
				this.items[i].setName(item.getName());
				this.items[i].setDescription(item.getDescription());
				this.items[i].setCreated(System.currentTimeMillis());
				this.items[i].setComments(item.getComments());
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
		for (int i = 0; i < this.index; i++) {
			if (this.items[i].getId().equals(id)) {
				item = this.items[i];
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
	public Item[] findByName(String name) {
		Item[] finder = new Item[this.index];
		int j = 0;
		for (int i = 0; i < this.index; i++) {
			if (this.items[i].getName().equals(name)) {
				finder[j] = this.items[i];
				j++;
			}
		}
		finder = Arrays.copyOf(finder, j);
		return finder;
	}
	/**
	*метод удаляет заявку по ключу.
	*@param id - ключ
	*/
	public void delete(String id) {
		int j = 0;
		for (int i = 0; i < this.index; i++) {
			if (this.items[i].getId().equals(id)) {
				j = i;
				break;
			}
		}
		for (int i = j; i < this.index - 1; i++) {
			this.items[i] = this.items[i + 1];
		}
		this.index--;
		this.items[this.index] = null;
	}
	/**
	*метод возвращает список все заявок.
	*@return finder
	*/
	public Item[] getAll() {
		Item[] finder = new Item[this.index];
		finder = Arrays.copyOf(this.items, this.index);
		return finder;
	}
}