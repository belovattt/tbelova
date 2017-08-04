package ru.job4j.shapes;

public class Square implements Shape {
    public String pic() {
        String sep = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder("*****");
        for (int i = 1; i <=3; i++) {
            s.append(sep);
            s.append("*   *");
        }
        s.append(sep);
        s.append("*****");
        return s.toString();
    }
}
