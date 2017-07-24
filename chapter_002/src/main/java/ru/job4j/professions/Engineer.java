package ru.job4j.professions;
/**
 *Class Engineer решение задания 3.1 части 002.
 *@author Tatyana Belova
 *@since 24.07.2017
*/
public class Engineer extends Profession {
	/**
	*специализация.
	*/
	private String job;
	/**
	*конструктор.
	*@param name - name
	*@param experience - experience
	*@param job - job
	*/
	Engineer(String name, int experience, String job) {
		super(name, experience);
		this.job = job;
	}
	/**
	*метод возвращает место работы.
	*@return name
	*/
	public String getJob() {
		return this.job;
	}
	/**
	*метод возвращает строку "Инженер-job name разрабатывает plan".
	*@param plan - plan
	*@return строка
	*/
	public String design(Plan plan) {
		return "Инженер-" + this.getJob() + " " + this.getName() + " разрабатывает " + plan.getName();
	}
}