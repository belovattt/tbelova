package ru.job4j.array;
import java.util.Arrays;
/**
 *Class ArrayDuplicate решение задачи части 001 урок 5.3.
 *@author Tatyana Belova
 *@since 07.07.2017
*/
public class ArrayDuplicate {
	/**
	*метод удаляет из массива повторяющиеся элементы.
	*@param array - array
	*@return массив без повторяющихся элементов
	*/
	public String[] remove(String[] array) {
		int end = 0;
		for (int i = 1; i < array.length; i++) {
			if (!is(array, end, array[i])) {
				end++;
				array[end] = array[i];
			}
		}
		array = Arrays.copyOf(array, end + 1);
		return array;
	}
	/**
	*метод метод проверяет, встречается ли строка s среди элементов массива от 0 до end.
	*@param array - array
	*@param end - end
	*@param s - строка
	*@return true, если встречается
	*/
	boolean is(String[] array, int end, String s) {
		boolean f = false;
		int i = 0;
		do {
			if (s.equals(array[i])) {
				f = true;
			}
			i++;
		} while ((i <= end) && !f);
		return f;
	}
}