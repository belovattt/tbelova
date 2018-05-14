package ru.job4j.producer_consumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * класс для реализации блокирующей очереди.
 * Блокитруются попытки добавить элемент, если размер очереди больше или равен 3
 * и блокируются попытки взять элемент из очереди, пока очередь пустая
 *
 * @param <T>
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    /**
     * список для реализации очереди
     */
    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    /**
     * метод блокирует попытки добавить элемент, если очередь заполнена.
     * как только в очереди освобождается место, элемент добавляется
     *
     * @param value - элемент
     */
    public synchronized void offer(T value) {
        while (this.queue.size() >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.queue.offer(value);
        notifyAll();
    }

    /**
     * метод блокирует попытки удалить элемент из очереди, если она пустая.
     * при появлении элементов в очереди первый из них удаляется
     *
     * @return удаляемый элемент
     */
    public synchronized T poll() {
        while (this.queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return (T) this.queue.poll();
    }
}
