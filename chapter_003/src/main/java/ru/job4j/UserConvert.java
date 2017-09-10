package ru.job4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<Integer, User>();
        for (User user : list) {
            map.put(user.getId(), user);
        }
        return map;
    }
}
