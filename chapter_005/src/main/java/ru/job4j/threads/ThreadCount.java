package ru.job4j.threads;

public class ThreadCount extends Thread {
    private Counter counter;
    ThreadCount(final Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        this.counter.increment();
    }
}
