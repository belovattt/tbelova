package ru.job4j.threadpool;

/**
 * класс для тестирован я класса ThreadPool.
 * реализует отдельный поток, котрый выводит свой номер
 */
public class Work implements Runnable {
    /**
     * номер потока
     */
    private int number;

    /**
     * конструктор
     * @param number - номер
     */
    Work (int number) {
        this.number = number;
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
System.out.printf("Поток номер %d начал работу\n", number);
    }
}
