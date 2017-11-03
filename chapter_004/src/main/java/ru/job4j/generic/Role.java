package ru.job4j.generic;

/**
 * информация о статусе.
 */
public class Role extends Base{
    private static Integer numberRole = 0;
    private String idRole;

    private String status;
    public Role(String idRole, String status) {
        this.idRole = idRole;
        this.status = status;
    }
    public static String getNewId() {
        numberRole++;
        return numberRole.toString();
    }

    @Override
    String getId() {
        return this.idRole;
    }

    @Override
    void setId(String idRole) {
        this.idRole = idRole;
    }
    public String getStatus() {
        return this.status;
    }
    public static String getNewIdRole() {
        numberRole++;
        return numberRole.toString();
    }
}
