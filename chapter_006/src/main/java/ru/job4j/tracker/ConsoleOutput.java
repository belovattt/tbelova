package ru.job4j.tracker;
/**
 * Class ConsoleOutput решение задачи второго модуля.
 * @author Tatyana Belova
 * @since 1.08.2017
 */
public class ConsoleOutput implements Output {
	/**
	 * метод выводит строку line в консоль.
	 * @param line - line
	 */
	public final void write(final String line) {
		System.out.println(line);
	}
	/**
	 * здесь метод не нужен.
	 * @return null
	 */
	public final String[] getLines() {
		return null;
	}
}
