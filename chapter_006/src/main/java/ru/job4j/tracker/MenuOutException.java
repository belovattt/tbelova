package ru.job4j.tracker;

/**
 * class MenuOutException.
 * *@author Tatyana Belova
 *  *@since 24.08.2018
 */

public class MenuOutException extends RuntimeException {
    /**
     * конструктор.
     * @param msg - msg
     */
    MenuOutException(final String msg) {
        super(msg);
    }
}
