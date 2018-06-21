package ru.job4j.switcher;

/**
 * класс для тестирования.
 */
public class TesterOfOneTwoSwitcher {
    public static void main(String[] args) {
        StringOfNumbers str = new StringOfNumbers();
        Thread addOne = new Thread(new AddOne(str));
        addOne.start();
        Thread addTwo = new Thread(new AddTwo(str));
        addTwo.start();
        try {
            addOne.join();
            addTwo.join();
        } catch (InterruptedException e) {

        }
        System.out.println(str.getStr());
    }
}
