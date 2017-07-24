package ru.job4j.professions;
/**
 *Class Pupil.
 *@author Tatyana Belova
 *@since 22.07.2017
*/
public class Pupil {
	/**
	*имя.
	*/
	private String name;
	/**
	*конструктор.
	*@param name - name
	*/
	Pupil(String name) {
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