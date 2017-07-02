package ru.job4j.condition;
/**
 *Class Triangle решение задачи части 001 урок 3.2.
 *@author Tatyana Belova
 *@since 02.07.2017
*/
public class Triangle {
	/**
	*Первая вершина.
	*/
	private Point a;
	/**
	*Вторая вершина.
	*/
	private Point b;
	/**
	*Третья вершина.
	*/
	private Point c;
	/**
	*Конструктор создает треугольник с вершинами a, b, c.
	*@param a - a
	*@param b - b
	*@param c - c
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	*метод для вычисления площади треугольника.
	*@return площадь, если треугольник существует, -1 - если не существует
	*/
	public double area() {
		double p = (distance(this.a, this.b) + distance(this.b, this.c) + distance(this.c, this.a)) / 2;
		double s;
		if (this.is()) {
				s = Math.pow(p * (p - distance(this.a, this.b)) * (p - distance(this.b, this.c)) * (p - distance(this.c, this.a)), 0.5);
		} else {
			s = -1;
		}
		return s;
	}
	/**
	*метод для вычисления расстояния между точками a и b.
	*@param a - a
	*@param b - b
	*@return расстояние
	*/
	private double distance(Point a, Point b) {
		return Math.pow(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2), 0.5);
	}
	/**
	*метод для проверки существования треугольника.
	*@return true, если треугольник существует, false - если не существует
	*/
	private boolean is() {
		boolean f;
		if ((distance(this.a, this.b) + distance(this.b, this.c) > distance(this.a, this.c)) && (distance(this.a, this.c) + distance(this.b, this.c) > distance(this.a, this.b)) && (distance(this.a, this.b) + distance(this.a, this.c) > distance(this.b, this.c))) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}
}