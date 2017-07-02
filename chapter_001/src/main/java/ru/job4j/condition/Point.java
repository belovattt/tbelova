package ru.job4j.condition;

/**
 *Class Point решение задачи части 001 урок 3.2.
 *@author Tatyana Belova
 *@since 02.07.2017
*/

public class Point {
	/**
	*Поле для записи первой координаты.
	*/
   private int x;
   /**
	*Поле для записи второй координаты.
	*/
   private int y;
   /**
	*Конструктор для точки с координатами х, y.
	*@param x - первая координата
	*@param y - вторая координата
	*/
    public  Point(int x, int y) {
      this.x = x;
      this.y = y;
	}
	/**
	*Метод возвращает коордианту х.
	*@return x
	*/
	public int getX() {
      return this.x;
	}
	/**
	*Метод возвращает коордианту y.
	*@return y
	*/
	public int getY() {
     return this.y;
	}
	/**
	*Метод проверяет, лежит ли точка на прямой y=ax+b.
	*@param a - a
	*@param b - b
	*@return true/false
	*/
	public boolean is(int a, int b) {
		return this.y == a * this.x + b;
	}
}