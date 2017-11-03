package ru.job4j.generic;

/**
 * информация об одном пользователе.
 */

public class User extends Base {
    /**
     * количество созданных объектов для генерации уникального id
     */
    private static  Integer number = 0;
    /**
     * id пользователя
     */
    private String id;
    /**
     * имя пользолвателя
     */
    private String name;

    /**
     * конструктор.
     * @param id - id пользователя
     * @param name - имя пользователя
     */
    User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * метод для генерации id пользователя
     * @return id в строковом формате
     */
    public static String getNewId() {
        number++;
        return number.toString();
    }

    @Override
    String getId() {
        return this.id;
    }

    @Override
    void setId(String id) {
        this.id = id;
    }

    /**
     * метод возвращает имя пользователя
     * @return имя пользователя
     */
    public String getName() {
        return this.name;
    }
}
