package ru.job4j.tracker;


import java.sql.Date;


/**
 *Class Item.
 *@author Tatyana Belova
 *@since 24.08.2018
*/
public class Item {
	/**
	*ключ.
	*/
	private int id;
	/**
	*наименование.
	*/
	private String name;
	/**
	*описание.
	*/
	private String description;
	/**
	*дата создания.
	*/
	private Date created;
	/**
	*комментарии.
	*/
	private String comments;
	/**
	*метод возвращает ключ.
	*@return id
	*/
	public int getId() {
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
	public Date getCreated() {
		return this.created;
	}
	/**
	*метод возвращает комментарии.
	*@return comments
	*/
	public String getComments() {
		return this.comments;
	}
	/**
	*метод устанавливает ключ.
	*@param id - id
	*/
	public void setId(int id) {
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

	*/
	public void setCreated(Date date) {
		this.created = date;
	}
	/**
	*метод устанавливает комментарии.
	*@param comments - comments
	*/
	public void setComments(String comments) {
		this.comments = comments;
	}
}