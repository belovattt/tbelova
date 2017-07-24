package ru.job4j.professions;
/**
 *Class Teacher решение задания 3.1 части 002.
 *@author Tatyana Belova
 *@since 22.07.2017
*/
public class Teacher extends Profession {
	/**
	*категория.
	*/
	private int category;
	/**
	*предмет.
	*/
	private String subject;
	/**
	*конструктор.
	*@param name - name
	*@param experience - experience
	*@param category - category
	*@param subject - subject
	*/
	Teacher(String name, int experience, int category, String subject) {
		super(name, experience);
		this.category = category;
		this.subject = subject;
	}
	/**
	*метод возвращает строку "Учитель name учит pupil".
	*@param pupil - pupil
	*@return строка
	*/
	public String teach(Pupil pupil) {
		return "Учитель " + this.getName() + " учит " + pupil.getName();
	}
}