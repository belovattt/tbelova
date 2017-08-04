package ru.job4j.shapes;

public class Triangle implements Shape {
    public String pic() {
       String sep = System.getProperty("line.separator");
       StringBuilder s = new StringBuilder("  *  ");
       s.append(sep);
       s.append(" *** ");
       s.append(sep);
       s.append("*****");
       return s.toString();
    }
}
