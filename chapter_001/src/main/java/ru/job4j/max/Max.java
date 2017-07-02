package ru.job4j.max;

/**
 *Class Max решение задачи части 001 урок 3.1.
 *@author Tatyana Belova
 *@since 02.07.2017
*/
class Max {
	/**
	*Метод для вычисления максимума из двух чисел.
	*@param first - первое число
	*@param second - второе число
	*@return максимум
	*/
	public int max(int first, int second) {
		return first > second ? first : second;
	}
}
