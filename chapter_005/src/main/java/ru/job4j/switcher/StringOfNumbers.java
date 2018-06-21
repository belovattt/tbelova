package ru.job4j.switcher;

/**
 * Класс для создагия строки двумя потоками.
 * Сначала первый поток пишет в строку 111, затем второй пишет 222 и т.д.
 */
public class StringOfNumbers {
    /**
     * строка для записи цифр.
     */
    private StringBuffer str = new StringBuffer();
    /**
     * имя первого потока.
     */
    private final String firstThread = "Thread-0";
    /**
     * имя второго потока.
     */
    private final String secondThread = "Thread-1";
    /**
     * количество цифр, кторое пишет поток за одну блокировку.
     */
    private final int actionsMax = 3;
    /**
     * количество цифр, написанных потоком за текущую блокировку.
     */
    private int actions = 0;

    /**
     * поток, захвативший блокировку.
     */
    private volatile String lockingThread = "Thread-0";

    /**
     * метод позволяет одному из потоков добавить цифру в строку.
     * после добавления actionMax цифр происходит переключения на второй поток.
      * @param number - добавляемая цифра
     * @throws InterruptedException
     */
    public void addNumber(int  number) throws InterruptedException {
        synchronized (this) {

            while (!Thread.currentThread().getName().equals(lockingThread)) {
                wait();
            }
            this.str.append(number);
            actions++;
            if (actions >= actionsMax) {
                actions = 0;
                if (Thread.currentThread().getName().equals("Thread-0")) {
                    lockingThread = "Thread-1";
                } else {
                    lockingThread = "Thread-0";
                }
                notifyAll();
            }
        }
    }

    /**
     * метод возвращает содержимое строки.
     * @return строка
     */
    public String getStr() {

        return this.str.toString();
    }
}
