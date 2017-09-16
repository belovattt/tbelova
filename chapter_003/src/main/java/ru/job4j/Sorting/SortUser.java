package ru.job4j.Sorting;

import java.util.*;

/**
 * Class SortUser.
 *
 * @author Tatyana Belova
 * @since 14.09.2017
 */

public class SortUser {
    /**
     * метод получает список и возвращает его в виде упорядоченного дерева, сортировка по возрасту.
     * @param userList - список
     * @return дерево
     */
    public Set<User> sort (List<User> userList){
        TreeSet<User> users = new TreeSet<User>();
        users.addAll(userList);
        return users;
    }
    /**
     * метод получает список и возвращает его в виде списка, упорядоченного по длине имени.
     * @param userList - список
     * @return список
     */
    public List<User> sortNameLength (List<User> userList) {
        /**
         * класс реализует компаратор по длине имени.
         */
        class UserComparator implements Comparator<User> {
            /**
             * метод получает два объекта User и возвращает разность длин полей name.
             * @param user1 - первый объект
             * @param user2 - второй объект
             * @return разность длин полей name
             */
            public int compare(User user1, User user2) {
                return user1.getName().length() - user2.getName().length();
            }
        }
        Collections.sort(userList, new UserComparator());
        return userList;
    }
    /**
     * метод получает список и возвращает его в виде списка, упорядоченного сначала по имени, потом по возрасту.
     * @param userList - список
     * @return список
     */
    public List<User> sortByAllFields (List<User>userList) {
        /**
         * класс реализует компаратор сначала по имени, затем по возрасту.
         */
        class UserComparator implements Comparator<User> {
            /**
             * метод получает два объекта User и возвращает разность возраста, если имена одинаковые, и результат сревнения имен, если имена разные..
             * @param user1 - первый объект
             * @param user2 - второй объект
             * @return результат сравнения user1 и user2
             */
            public int compare(User user1, User user2) {
                return user1.getName().equals(user2.getName()) ? user1.getAge() - user2.getAge() : user1.getName().compareTo(user2.getName());
            }
        }
        Collections.sort(userList, new UserComparator());
        return userList;
    }
}
