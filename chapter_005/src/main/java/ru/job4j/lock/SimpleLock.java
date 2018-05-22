package ru.job4j.lock;

/**
 * класс реализует механизм блокировок Lock.
 */
public class SimpleLock {
    /**
     * включена ли блокировка.
     */
    private boolean isLocked = false;
    /**
     * поток, включивший блокировку.
     */
    private Thread lockingThread = null;
    /**
     * сколько раз блокирующий поток включал блокировку.
     */
    private int countLock = 0;

    /**
     * метод включает блокировку.
     */
    public void lock() {
        try {
            while ((isLocked) && (lockingThread != Thread.currentThread())) {
                wait();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isLocked = true;
        countLock++;
        this.lockingThread = Thread.currentThread();
    }

    /**
     * метод выключает блокировку.
     */
    public void unlock() {
        if (this.lockingThread == Thread.currentThread()) {
            countLock--;
            if (countLock == 0) {
                isLocked = false;
                lockingThread = null;
                notifyAll();
            }
        }
    }
}
