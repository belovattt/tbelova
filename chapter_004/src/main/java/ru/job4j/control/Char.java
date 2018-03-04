package ru.job4j.control;

/**
 * класс-обертка для char
 */

public class Char {
    /**
     * метод возвращает символ
     * @return symbol
     */
    public char getSimbol() {
        return symbol;
    }

    /**
     * метод записывает символ
     * @param symbol
     */
    public void setSimbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * поле для символа
     */
    private char symbol;

    /**
     * конструктор
     * @param symbol - символ
     */
    public Char(char symbol) {
        this.symbol = symbol;
    }
    /**
     * метод сравнивает this с o
     * @param o - объект
     * @return true, если ссылки равны или поля symbol у объектов равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Char)) return false;
        Char aChar = (Char) o;
        return symbol == aChar.symbol;
    }

    /**
     * метод преопределяет hashCode
     * @return (int) symbol
     */
    @Override
    public int hashCode() {
        return (int) symbol;
    }
}
