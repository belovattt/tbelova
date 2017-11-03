package ru.job4j.generic;

/**
 * класс для хранения данных о статусах.
 */
public class RoleStore extends AbstractStore<Role> {
    /**
     * конструктор.
     * @param size - начальный размер
     */
    public RoleStore(int size) {
        super(size);
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("");
        try {
            for (int i = 0; i < this.userArray.getLength(); i++) {
                result.append(this.userArray.get(i).getId());
                result.append("-");
                result.append(this.userArray.get(i).getStatus());
                result.append(" ");
            }
        } catch (OutOfSimpleArrayRangeException oosare) {
        }
        return result.toString();
    }
}
