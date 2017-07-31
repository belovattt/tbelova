package ru.job4j.module2;

/**
 *Class StubInput решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 30.07.2017
*/
public class StubInput implements Input {
	/**
	*массив ответов.
	*/
	private String[] answers;
	/**
	*индекс текущего элемента массива.
	*/
	private int position = 0;
	/**
	*конструктор.
	*@param answers - массив ответов
	*/
	public StubInput(String[] answers) {
		this.answers = answers;
	}
	/**
	*метод эмулирует ответ пользователя.
	*@param question - вопрос
	*@return answers[position++] - ответ
	*/
	public String ask(String question) {
		return this.answers[this.position++];
	}
}