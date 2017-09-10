package ru.job4j.module2;

import java.util.ArrayList;

/**
 *Class Item решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 26.07.2017
*/
public class Item {
	/**
	*ключ.
	*/
	private String id;
	/**
	*наименование.
	*/
	private String name;
	/**
	*описание.
	*/
	private String description;
	/**
	*дата создания в миллисекундах.
	*/
	private long created;
	/**
	*комментарии.
	*/
	private ArrayList<String> comments;
	/**
	*метод возвращает ключ.
	*@return id
	*/
	public String getId() {
		return this.id;
	}
	/**
	*метод возвращает имя.
	*@return name
	*/
	public String getName() {
		return this.name;
	}
	/**
	*метод возвращает описание.
	*@return description
	*/
	public String getDescription() {
		return this.description;
	}
	/**
	*метод возвращает дату создания.
	*@return created
	*/
	public long getCreated() {
		return this.created;
	}
	/**
	*метод возвращает комментарии.
	*@return comments
	*/
	public ArrayList<String> getComments() {
		return this.comments;
	}
	/**
	*метод устанавливает ключ.
	*@param id - id
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	*метод устанавливает имя.
	*@param name - name
	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
	*метод устанавливает описание.
	*@param description - description
	*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	*метод устанавливает дату создания.
	*@param created - created
	*/
	public void setCreated(long created) {
		this.created = created;
	}
	/**
	*метод устанавливает комментарии.
	*@param comments - comments
	*/
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
}