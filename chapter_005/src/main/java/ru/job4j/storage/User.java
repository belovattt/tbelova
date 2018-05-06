package ru.job4j.storage;


/**
 * класс User для хранения сведений о пользователе
 */
public class User {
    /**
     * id пользователя
     */
    private int id;
    /**
     * счет пользователя
     */
    private int amount;

    /**
     * возвращает id
     *
     * @return id
     */
    int getId() {
        return id;
    }

    /**
     * записывает id
     *
     * @param id - id
     */
    void setId(int id) {
        this.id = id;
    }

    /**
     * возвращает счет
     *
     * @return счет
     */
    int getAmount() {
        return amount;
    }

    /**
     * записывает счет
     *
     * @param amount - счет
     */
    void setAmount(int amount) {
        this.amount = amount;
    }

}
