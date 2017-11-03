package ru.job4j.generic;

/**
 * класс UserStore для хранения данных о пользователях
 */
public class UserStore extends AbstractStore<User> {
    /**
     * конструктор.
     * @param size - начальное количество записей
     */

    public UserStore(int size) {
        super(size);
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer("");
        try {
            for (int i = 0; i < this.userArray.getLength(); i++) {
                result.append(this.userArray.get(i).getId());
                result.append("-");
                result.append(this.userArray.get(i).getName());
                result.append(" ");
            }

        } catch (OutOfSimpleArrayRangeException oosare) {
        }
        return result.toString();
    }
}


