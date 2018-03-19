package ru.job4j.threads;

public class Problems {
    int a = 1;
    int b = 1;

    class Thread1 implements Runnable {

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
        public void run() {
            a = 2;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {

            }
            a = 3;
            b = a;

        }
    }

    class Thread2 implements Runnable {

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
        public void run() {
            System.out.println(a);
            System.out.println(b);
        }
    }

    public void init() {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

}
