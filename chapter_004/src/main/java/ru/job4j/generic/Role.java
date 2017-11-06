package ru.job4j.generic;

/**
 * информация о статусе.
 */
public class Role extends Base{
    private static Integer numberRole = 0;


    private String status;
    public Role(String id, String status) {
        this.setId(id);
        this.status = status;
    }
    public static String getNewId() {
        numberRole++;
        return numberRole.toString();
    }


    public String getStatus() {
        return this.status;
    }
    public static String getNewIdRole() {
        numberRole++;
        return numberRole.toString();
    }
}
