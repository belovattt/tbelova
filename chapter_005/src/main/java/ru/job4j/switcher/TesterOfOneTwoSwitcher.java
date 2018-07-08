package ru.job4j.switcher;

import java.util.concurrent.CyclicBarrier;

/**
 * класс для тестирования.
 */
public class TesterOfOneTwoSwitcher {
    public static void main(String[] args) {
        final CyclicBarrier bar = new CyclicBarrier(2);
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < 31; i++) {
            Thread addOne = new Thread(new AddOne(str, bar));
            addOne.start();
            Thread addTwo = new Thread(new AddTwo(str, bar));
            addTwo.start();
            try {
                addOne.join();
                addTwo.join();
            } catch (InterruptedException e) {

            }

        }

        System.out.println(str);
    }
}
