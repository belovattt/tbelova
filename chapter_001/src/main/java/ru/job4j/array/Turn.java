package ru.job4j.array;
/**
 *Class Turn решение задачи части 001 урок 5.0.
 *@author Tatyana Belova
 *@since 04.07.2017
*/
public class Turn {
	/**
	*метод переворачивает массив.
	*@param array - array
	*@return перевернутый массив
	*/
	public int[] back(int[] array) {
		int n = array.length - 1;
		int c;
		for (int i = 0; i <= n / 2; i++) {
			c = array[i];
			array[i] = array[n - i];
			array[n - i] = c;
		}
		return array;
	}
}