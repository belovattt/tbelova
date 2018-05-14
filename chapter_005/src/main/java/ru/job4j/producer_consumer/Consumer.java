package ru.job4j.producer_consumer;

/**
 * класс реализует поток для удаления элемента из очереди
 * @param <T>
 */
public class Consumer<T> implements Runnable {
    /**
     * очередь.
     */
    private SimpleBlockingQueue<T> queue;

    /**
     * конструктор.
     * @param queue - очередь
     */
    Consumer(SimpleBlockingQueue<T> queue) {
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
            T k = this.queue.poll();
            System.out.printf("Элемент %s удален\n", k.toString());
        }
    }
}
