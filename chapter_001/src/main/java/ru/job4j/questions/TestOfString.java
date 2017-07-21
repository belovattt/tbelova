package ru.job4j.questions;
/**
 *Class TestOfString решение задачи части 001 урок 6.
 *@author Tatyana Belova
 *@since 15.07.2017
*/
public class TestOfString {
	/**
	*метод проверяет, является ли строка sub подстрокой строки origin.
	*@param origin - origin
	*@param sub - sub
	*@return true, если является
	*/
	public boolean contains(String origin, String sub) {
		boolean is = false;
		char[] big = origin.toCharArray();
		char[] small = sub.toCharArray();
		int i = 0;
		while ((i <= big.length - small.length) && (!is)) {
			int j = 0;
			do {
				if (big[i + j] == small[j]) {
					is = true;
				} else {
					is = false;
				}
				j++;
			}
			while ((j < small.length) && (is));
			i++;
		}
		return is;
	}
}
