package ru.job4j.calculator;

/**
 *Class Calculator решение задачи части 001 урок 2.3.
 *@author Tatyana Belova
 *@since 01.07.2017
*/

public class Calculator {
	/**
	*Поле для записи результата вычислений.
	*/
    private double result;
	/**
	*Метод для вычисления суммы двух чисел.
	*@param first - первое слагаемое
	*@param second - второе слагаемое
	*/
    public void add(double first, double second) {
        this.result = first + second;
    }
	/**
	*Метод для вычисления разности двух чисел.
	*@param first - вычитаемое
	*@param second - уменьшаемое
	*/
	public void substruct(double first, double second) {
        this.result = first - second;
    }
	/**
	*Метод для вычисления частного двух чисел.
	*@param first - делимое
	*@param second - делитель
	*/
	public void div(double first, double second) {
        this.result = first / second;
    }
	/**
	*Метод для вычисления произведения двух чисел.
	*@param first - первый множитель
	*@param second - второй множитель
	*/
	public void multiple(double first, double second) {
        this.result = first * second;
    }
    /**
	*Метод для вывода результата.
	*@return this.result
	*/
    public double getResult() {
        return this.result;
    }
}