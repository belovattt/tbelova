package ru.job4j.threads;

public class SetOfCounters {

    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread thread1 = new ThreadCount(counter);
        Thread thread2 = new ThreadCount(counter);
        thread1.start();
        thread2.start();
    }
}
