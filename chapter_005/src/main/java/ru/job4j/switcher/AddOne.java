package ru.job4j.switcher;
/**
 * поток в цикле добавляет в строку цифру 1.
 */
public class AddOne implements Runnable {
    /**
     * строка.
     */
    private StringOfNumbers str;

    /**
     * конструктор.
     * @param str - строка
     */
    AddOne(StringOfNumbers str) {
this.str = str;
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
        for (int i = 1; i < 31; i++) {
            try {
                this.str.addNumber(1);
            } catch (InterruptedException e) {

            }
        }
    }
}

