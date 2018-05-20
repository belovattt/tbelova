package ru.job4j.threadpool;
import ru.job4j.threadpool.ThreadPool;

/**
 * Класс демонстрирует работу ThreadPool.
 */
public class TreadPoolWorks {
    /**
     * метод слоздает пул и добавляет в него 10 задач.
     * @param args - args
     */
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        for (int i = 0; i < 10; i++) {
            Work work = new Work(i);
            pool.add(work);
        }
    }
}
