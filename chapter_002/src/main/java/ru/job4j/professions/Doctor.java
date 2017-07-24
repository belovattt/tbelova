package ru.job4j.professions;
/**
 *Class Doctor решение задания 3.1 части 002.
 *@author Tatyana Belova
 *@since 23.07.2017
*/
public class Doctor extends Profession {
	/**
	*специализация.
	*/
	private String specialization;
	/**
	*конструктор.
	*@param name - name
	*@param experience - experience
	*@param specialization - specialization
	*/
	Doctor(String name, int experience, String specialization) {
		super(name, experience);
		this.specialization = specialization;
	}
	/**
	*метод возвращает строку "Доктор name лечит person".
	*@param person - person
	*@return строка
	*/
	public String heal(Person person) {
		return "Доктор " + this.getName() + " лечит " + person.getName() + " от " + person.getDiagnosis();
	}
	/**
	*метод записывает диагноз пациенту.
	*@param person - пациент
	*@param diagnosis - диагноз
	*/
	public void diagnose(Person person, String diagnosis) {
		person.setDiagnosis(diagnosis);
	}
}