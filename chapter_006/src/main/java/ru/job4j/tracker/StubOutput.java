package ru.job4j.tracker;

import java.util.Arrays;

/**
 *Class StubOutput решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 1.08.2017
*/
public class StubOutput implements Output {
	/**
	*массив для вывода.
	*/
	private String[] lines = new String[100];
	/**
	*номер первого свободного элемента.
	*/
	private int index = 0;
	/**
	*метод добавляет строку line в массив lines.
	*@param line - line
	*/
	public void write(String line) {
		lines[index++] = line;
	}
	/**
	*метод возвращает заполненные элементы массива lines.
	*@return lines
	*/
	public String[] getLines() {
		this.lines = Arrays.copyOf(this.lines, this.index);
		return this.lines;
	}
	/**
	*метод возвращает index.
	*@return index
	*/
	public int getIndex() {
		return this.index;
	}
}