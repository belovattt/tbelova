package ru.job4j.module2;

import java.util.Scanner;

/**
 *Class ConsoleInput решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 28.07.2017
*/
public class ConsoleInput implements Input {
	/**
	*scanner.
	*/
	private Scanner scanner = new Scanner(System.in);
	/**
	*метод задает пользователю вопрос и получает ответ.
	*@param question - вопрос
	*@return scanner.nextLine - ответ
	*/
	public String ask(String question) {
		System.out.print(question);
		return scanner.nextLine();
	}
}