package ru.job4j.questions;
/**
 *Class ArraySort решение тестового задания части 001.
 *@author Tatyana Belova
 *@since 21.07.2017
*/
public class ArraySort {
	/**
	*метод записывает элементы из упорядоченных массивов array1 и array2 в один упорядоченный массив.
	*@param array1 - array1
	*@param array2 - array2
	*@return упорядоченный массив
	*/
	public int[] sequencing(int[] array1, int[] array2) {
		int k = 0;
		int m = 0;
		int[] big = new int[array1.length + array2.length];
		for (int i = 0; i < array1.length + array2.length; i++) {
			if ((m > array2.length - 1) || ((k < array1.length) && (array1[k] < array2[m]))) {
				big[i] = array1[k];
				k++;
			} else {
				big[i] = array2[m];
				m++;
			}
		}
		return big;
	}
}