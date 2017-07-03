package ru.job4j.loop;
/**
 *Class Counter решение задачи части 001 урок 4.1.
 *@author Tatyana Belova
 *@since 03.07.2017
*/
public class Counter {
	/**
	*метод для вычисления суммы четныx чисел в диапазоне от start до finish.
	*@param start - start
	*@param finish - finish
	*@return sum
	*/
	public int add(int start, int finish) {
		int sum = 0;
		if (start % 2 != 0) {
			start++;
		}
		for (int i = start; i <= finish; i += 2) {
			sum += i;
		}
		return sum;
	};
}