package ru.job4j.loop;
/**
 *Class Board решение задачи части 001 урок 4.3.
 *@author Tatyana Belova
 *@since 03.07.2017
*/
public class Board {
	/**
	*метод для составления строки.
	*@param width - ширина доски
	*@param height - высота доски
	*@return вид доски
	*/
	public String paint(int width, int height) {
		StringBuilder matrix = new StringBuilder();
		char cell = 'x';
		String line = System.getProperty("line.separator");
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				matrix.append(cell);
				if (cell == 'x') {
					cell = ' ';
				} else {
					cell = 'x';
				}
			}
			matrix.append(line);
		}
		return matrix.toString();
	}
}
