package ru.job4j.tracker;

/**
 * sql-запросы.
 */

public final class Queries {
    /**
     * constructor.
     */
    private Queries() {

}
    /**
     * запрос на добавление строки.
     */
    static final String ADDQUERY =
            "insert into items (username, description, created, comments) values (?, ?, ?, ?)";
    /**
     * запрос на обновление строки.
     */
    static final String UPDATEQUERY =
            "update items set username = ?, description = ?, comments = ? where items.id = ?";
    /**
     * поиск стпоки по id.
     */
    static final String FINDBYIDQUERY = "select * from items where items.id = ?";
    /**
     * ариск строки по имени.
     */
    static final String FINDBYNAMEQUERY = "select * from items where items.username = ?";
    /**
     * запрос на удаление строки.
     */
    static final String DELETEQUERY = "delete from items where items.id = ?";
    /**
     * вся таблица.
     */
    static final String GETALLQUERY = "select * from items";
    /**
     * создать таблицу.
     */
    static final String CREATETABLE =
            "CREATE TABLE IF NOT EXISTS Items(id serial primary key, userName varchar(100), "
                    +
                    "description varchar(100), created DATE, comments text)";
    /**
     * one.
     */
    static final int ONE = 1;
    /**
     * two.
     */
    static final int TWO = 2;
    /**
     * three.
     */
    static final int THREE = 3;
    /**
     * four.
     */
    static final int FOUR = 4;
    /**
     * five.
     */
    static final int FIVE = 5;
}

