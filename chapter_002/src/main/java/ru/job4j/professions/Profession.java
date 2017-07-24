package ru.job4j.professions;
/**
 *Class Profession решение задания 3.1 части 002.
 *@author Tatyana Belova
 *@since 22.07.2017
*/
public class Profession {
	/**
	*стаж.
	*/
	private int experience;
	/**
	*имя.
	*/
	private String name;
	/**
	*конструктор.
	*@param name - name
	*@param experience - experience
	*/
	Profession(String name, int experience) {
		this.name = name;
		this.experience = experience;
	}
	/**
	*метод возвращает имя.
	*@return name
	*/
	public String getName() {
		return this.name;
	}
}