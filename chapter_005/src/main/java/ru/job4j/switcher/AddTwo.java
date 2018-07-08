package ru.job4j.switcher;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * поток в цикле добавляет в строку цифру 1.
 */
public class AddTwo implements Runnable {
    /**
     * строка.
     */
    private StringBuffer str;
    /**
     * барьер.
     */
    private CyclicBarrier bar;

    /**
     * конструктор.
     *
     * @param str - строка
     */
    AddTwo(StringBuffer str, CyclicBarrier bar) {
        this.str = str;
        this.bar = bar;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            for (int j = 1; j < 4; j++) {
                this.str.append(2);
            }
            this.bar.await();
        } catch (InterruptedException e) {
        } catch (BrokenBarrierException be) {
        }

    }

}
