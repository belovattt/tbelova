package ru.job4j.professions;
/**
 *Class Person.
 *@author Tatyana Belova
 *@since 24.07.2017
*/
public class Person {
	/**
	*имя.
	*/
	private String name;
	/**
	*диагноз.
	*/
	private String diagnosis;
	/**
	*конструктор.
	*@param name - name
	*/
	Person(String name) {
		this.name = name;
	}
	/**
	*возвращает имя.
	*@return name
	*/
	public String getName() {
		return this.name;
	}
	/**
	*возвращает диагноз.
	*@return diagnosis
	*/
	public String getDiagnosis() {
		return this.diagnosis;
	}
	/**
	*записывает диагноз.
	*@param diagnosis - diagnosis
	*/
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
}