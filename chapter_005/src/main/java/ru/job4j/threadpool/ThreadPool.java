package ru.job4j.threadpool;


import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    /**
     * максимальное количество поток в пуле равно количеству ядер.
     */
    private final int maxThreads = Runtime.getRuntime().availableProcessors();
    /**
     * массив потоков.
     * размерность равна количеству ядер
     */
    private final PoolWork[] threads = new PoolWork[maxThreads];
    /**
     * в очередь помещаются задачи, пока нет свободных потоков.
     */
    private final LinkedBlockingQueue<Work> queue = new LinkedBlockingQueue();

    /**
     * конструктор.
     * запускаем потоки
     */
    ThreadPool() {
        for (int i = 0; i < maxThreads; i++) {
            threads[i] = new PoolWork();
            threads[i].start();
        }
    }

    /**
     * метод для добавления задачи в пул.
     * @param work - задача
     */
    public void add(Work work) {
        synchronized (queue) {
            this.queue.add(work);
            this.queue.notifyAll();
        }
    }

    private class PoolWork extends Thread {
        public void run() {
            /**
             * переменная для извлечения задачи из очереди.
             */
            Work work;
            /**
             * если в очереди нет задач, ждет.
             * когда появится, извлекает ее из очереди и запускает
             */
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    work = queue.poll();
                }
                try {
                    work.run();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
