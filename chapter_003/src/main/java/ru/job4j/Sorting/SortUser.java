package ru.job4j.Sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
