package ru.job4j;
import java.util.*;
/**
 * Class StartTesting для тестирования скорости работы коллекций.
 *
 * @author Tatyana Belova
 * @since 31.08.2017
 */
public class StartTesting {
    /**
     * количество добавляемых элементов.
     */
    static final int AMOUNT = 200000;
    /**
     * метод создает три коллекции, заполняет их случайными числами, потом удаляет элементы и печатает время работы.
     * @param args - args
     */
    public static void main(String[] args) {
        CollectionTesting ct = new CollectionTesting();
        LinkedList<String> link = new LinkedList<String>();
        ArrayList<String> array = new ArrayList<>(AMOUNT);
        TreeSet<String> tree = new TreeSet<String>();
        System.out.println("Время добавления элементов:");
        System.out.println(ct.add(link, AMOUNT));
        System.out.println(ct.add(array, AMOUNT));
        System.out.println(ct.add(tree, AMOUNT));
        System.out.println("Время удаления элементов:");
        System.out.println(ct.delete(link));
        System.out.println(ct.delete(array));
        System.out.println(ct.delete(tree));

    }


}
