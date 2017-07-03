package ru.job4j.loop;
/**
 *Class Factorial решение задачи части 001 урок 4.2.
 *@author Tatyana Belova
 *@since 03.07.2017
*/
public class Factorial {
	/**
	*метод для вычисления n!.
	*@param n - n>=0
	*@return n!
	*/
	public int calc(int n) {
		int f;
		if ((n == 0) || (n == 1)) {
			f = 1;
		} else {
			f = n * calc(n - 1);
		}
		return f;
	}
}