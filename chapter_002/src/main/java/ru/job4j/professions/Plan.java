package ru.job4j.professions;
/**
 *Class Plan.
 *@author Tatyana Belova
 *@since 24.07.2017
*/
public class Plan {
	/**
	*имя.
	*/
	private String name;
	/**
	*конструктор.
	*@param name - name
	*/
	Plan(String name) {
		this.name = name;
	}
	/**
	*возвращает имя.
	*@return name
	*/
	public String getName() {
		return this.name;
	}
}