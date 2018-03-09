package ru.job4j.threads;

import java.util.Scanner;

public class CountText {

    /**
     * класс реализует поток для подсчета
     * количества слов в тексте.
     */
    static class CountWords implements Runnable {
        private String text;

        CountWords(String text) {
            this.text = text;
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
        public void run() {
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if (((text.charAt(i) == ' ') && (text.charAt(i + 1) != '-')) || (text.charAt(i) == '\n')) {
                    count++;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

            }
            count++;
            System.out.println("words:" + count);
        }
    }

    /**
     * класс реализует поток для подсчета количества пробелов в тексте.
     */
    static class CountSpaces implements Runnable {
        /**
         * строка.
         */
        String text;

        /**
         * конструктор.
         *
         * @param text - текст
         */
        CountSpaces(String text) {
            this.text = text;
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
        public void run() {
            int count = 0;
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == ' ') {
                    count++;
                }
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("spaces:" + count);
        }
    }

    public static void main(String[] args) {
        System.out.println("Программа выполняется...");
        String text = "qwer ytre, trr - fhgd\nuyegf iuy!";
        Thread countWordsThread = new Thread(new CountWords(text));
        countWordsThread.start();
        Thread countSpacesThread = new Thread(new CountSpaces(text));
        countSpacesThread.start();
        try {
            countSpacesThread.join();
            countWordsThread.join();
        } catch (InterruptedException e) {
        }
        System.out.println("Вот и все!");
    }
}
