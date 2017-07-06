package ru.job4j.array;
/**
 *Class RotateArray решение задачи части 001 урок 5.0.
 *@author Tatyana Belova
 *@since 06.07.2017
*/
public class RotateArray {
	/**
	*метод поворачивает массив.
	*@param array - array
	*@return отсортированный массив
	*/
	public int[][] rotate(int[][] array) {
		int n = array.length;
		for (int i = 0; i <= (n - 1) / 2; i++) {
			for (int j = i; j <= n - 2 - i; j++) {
				int k = i;
				int l = j;
				int c = array[k][l];
				do {
						int a = array[l][n - 1 - k];
						array [l][n - 1 - k] = c;
						c = a;
						int m = k;
						k = l;
						l = n - 1 - m;
				} while ((k != i) || (l != j));
			}
		}
		return array;
	}
}