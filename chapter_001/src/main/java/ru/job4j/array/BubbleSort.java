package ru.job4j.array;
/**
 *Class BubbleSort решение задачи части 001 урок 5.0.
 *@author Tatyana Belova
 *@since 05.07.2017
*/
public class BubbleSort {
	/**
	*метод сортирует массив.
	*@param array - array
	*@return отсортированный массив
	*/
	public int[] sort(int[] array) {
		boolean theend;
		int n = array.length - 1;
		int c;
		do {
			theend = true;
			for (int i = 0; i < n; i++) {
				if (array[i] > array[i + 1]) {
					theend = false;
					c = array[i];
					array[i] = array[i + 1];
					array[i + 1] = c;
				}
			}
			n--;
		} while (!theend);
		return array;
	}
}