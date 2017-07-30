package ru.job4j.module2;
/**
 *Interface Input решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 28.07.2017
*/
public interface Input {
	/**
	*метод задает пользователю вопрос и получает ответ.
	*@param question - вопрос
	*@return - ответ
	*/
	String ask(String question);
}