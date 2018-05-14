package ru.job4j.producer_consumer;

import org.junit.Test;

public class ProducerConsumerTest {
    /**
     * Метод запускает две нити.
     *producer добавляет 10 элементов в блокирующую очередь
     * consumer удаляет 10 элементов из блокирующей очереди
     */
    @Test
    public void prodConsTest() {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();
        Thread producer = new Thread(new Producer<Integer>(queue));
        producer.start();
        Thread consumer = new Thread(new Consumer<Integer>(queue));
        consumer.start();
        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
