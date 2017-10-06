package ru.job4j.part4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * класс реализует два метода сортировки: по возрастанию и по убыванию.
 */

public class SortingCodes {
    /**
     * метод получает список отделов и подотделов в виде строк.
     * из каждой строки выделяет все отделы и подотделы и вставляет их в TreeSet с компаратором по умолчанию
     * @param list - список
     * @return дерево
     */
    public TreeSet<String> sortingAscending(List<String> list){
        TreeSet<String> tree = new TreeSet<>();
        for (String s: list) {
            insertSuper(tree, s);
        }
        return tree;
    }
    /**
     * метод получает список отделов и подотделов в виде строк.
     * из каждой строки выделяет все отделы и подотделы и вставляет их в TreeSet с определенным
     * согласно условию компаратором
     * @param list - список
     * @return дерево
     */
    public TreeSet<String> sortingDescending(List<String> list){
        /**
         * класс реализует компаратор для сортировки по убыванию.
         * строки, относящиеся к одному отделу, упорядочиваются по возрастанию,
         * к разным - по убыванию.
         */
        class ComparatorDes implements Comparator<String> {
            /**
             * метод сравнивает 2 строки.
             * если строки соответствуют одному отделу и имеют одинаковую длину, соблюдается обратный лексикографический порядок,
             * если строки соответствуют одному отделу и имеют разную длину, они упорядочиваются по возрастанию длины
             * если строки соответствуют разным отделам, соблюдается обратный лексикографический порядок
             * @param s1 - первая строка
             * @param s2 - вторая строка
             * @return результат стравнения
             */
            public int compare(String s1, String s2) {
                int result = 0;
                if (getDepartment(s1).equals(getDepartment(s2))) {
                    if (s1.length() == s2.length()) {
                        result = -s1.compareTo(s2);
                    } else {
                        result = s1.length() - s2.length();
                    }
                } else {
                    result = -s1.compareTo(s2);

                    }
                return result;
            }
        }
        TreeSet<String> tree = new TreeSet<>(new ComparatorDes());
        for (String s: list) {
            insertSuper(tree, s);
        }
        return tree;
    }
    /**
     * метод выделяет из строки все названия отделов и подотделов и вставляет их в дерево.
     * @param s - строка
     * @param tree - дерево
     */
    private static void insertSuper (TreeSet tree, String s){
        tree.add(s);
        if (s.contains(("/"))) {
            insertSuper(tree, s.substring(0, s.lastIndexOf("/")));
        }
    }
    /**
     * метод выделяет из строки название главного отдела.
     * @param s - строка
     * @return название отдела
     */
    private static String getDepartment(String s) {
        return s.contains("/") ? s.substring(0,s.indexOf("/")) : s;
    }
}
