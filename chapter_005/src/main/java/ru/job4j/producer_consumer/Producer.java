package ru.job4j.producer_consumer;

/**
 * класс реализует поток для вставки элемента в очередь.
 * @param <T>
 */

public class Producer<T> implements Runnable {
    /**
     * очередь.
     */
    private SimpleBlockingQueue queue;

    /**
     * конструктор.
     * @param queue - очередь
     */
    Producer(SimpleBlockingQueue queue) {
        this.queue = queue;
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
        for (int i = 1; i <= 10; i++) {
            this.queue.offer(i);
            System.out.printf("Элемент %d добавлен\n",i);
        }
    }
}
