package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserStoreTest {

    @Test
    /**
     * если изначально определить размерность 2 и добавить 3 элемента, то все элементы будут добавлены
     */
    public void treeElementsAdd() {
        UserStore userStore = new UserStore(2);
        User user1 = new User(User.getNewId(), "qqq");
        User user2 = new User(User.getNewId(), "www");
        User user3 = new User(User.getNewId(), "eee");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.toString(), is(user1.getId() + "-qqq " + user2.getId() + "-www " + user3.getId() + "-eee "));
    }
    @Test
    /**
     * если из массива, содержащего три элемента, удалить первый, два оставшихся буду сдвинуты в начало
     */
    public void firstElementDelete() {
        UserStore userStore = new UserStore(2);
        User user1 = new User(User.getNewId(), "qqq");
        User user2 = new User(User.getNewId(), "www");
        User user3 = new User(User.getNewId(), "eee");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        userStore.delete(user1.getId());
        assertThat(userStore.toString(), is(user2.getId() + "-www " + user3.getId() + "-eee "));
    }
    @Test
    /**
     * в массиве, содержащем три элемента, обновляется второй
     */
    public void secondElementUpdate() {
        UserStore userStore = new UserStore(2);
        User user1 = new User(User.getNewId(), "qqq");
        User user2 = new User(User.getNewId(), "www");
        User user3 = new User(User.getNewId(), "eee");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        userStore.update(new User(user2.getId(), "rrr"));
        assertThat(userStore.toString(), is(user1.getId() + "-qqq " + user2.getId() + "-rrr " + user3.getId() + "-eee "));
    }
}
