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
		int n = array.length - 1;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				int k = array[i][j];
				array[i][j] = array[j][i];
				array[j][i] = k;
				}
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n / 2; j++) {
				int m = array[i][j];
				array[i][j] = array[i][n - j];
				array[i][n - j] = m;
			}
		}
		return array;
	}
}