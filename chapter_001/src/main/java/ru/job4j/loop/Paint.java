package ru.job4j.loop;
/**
 *Class Paint решение задачи части 001 урок 4.4.
 *@author Tatyana Belova
 *@since 03.07.2017
*/
public class Paint {
	/**
	*метод для составления строки.
	*@param h - высота пирамиды
	*@return вид пирамиды
	*/
	public String piramid(int h) {
		StringBuilder piramida = new StringBuilder();
		// n - номер строки
		for (int n = 1; n <= h; n++) {
			// в n-ю строку добавляем пробелы
			for (int i = 1; i <= h - n; i++) {
				piramida.append(' ');
			}
			// в n-ю строку добавляем ^
			for (int j = 1; j <= 2 * n - 1; j++) {
				piramida.append('^');
			}
			piramida.append(System.getProperty("line.separator"));
		}
		return piramida.toString();
	}
}