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
	*Первая сторона.
	*/
	private double ab;
	/**
	*Вторая сторона.
	*/
	private double bc;
	/**
	*Третья сторона.
	*/
	private double ac;
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
		this.ab = distance(this.a, this.b);
		this.bc = distance(this.b, this.c);
		this.ac = distance(this.c, this.a);
		double p = (this.ab + this.bc + this.ac) / 2;
		double s;
		if (this.is()) {
				s = Math.pow(p * (p - this.ab) * (p - this.bc) * (p - this.ac), 0.5);
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
		if ((this.ab + this.bc > this.ac) && (this.ac + this.bc > this.ab) && (this.ab + this.ac > this.bc)) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}
}