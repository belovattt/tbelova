package ru.job4j.tracker;

import java.util.Arrays;

/**
 *Class StubOutput решение задачи второго модуля.
 *@author Tatyana Belova
 *@since 1.08.2017
*/
public class StubOutput implements Output {
    /**
     * размер массива.
     */
    private final int maxVal = 100;
	/**
	*массив для вывода.
	*/
	private String[] lines = new String[maxVal];
	/**
	*номер первого свободного элемента.
	*/
	private int index = 0;
	/**
	*метод добавляет строку line в массив lines.
	*@param line - line
	*/
	public final void write(final String line) {
		lines[index++] = line;
	}
	/**
	*метод возвращает заполненные элементы массива lines.
	*@return lines
	*/
	public final String[] getLines() {
		this.lines = Arrays.copyOf(this.lines, this.index);
		return this.lines;
	}
}
