package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RoleStoreTest {
    @Test
    /**
     * если изначально определить размерность 2 и добавить 3 элемента, то все элементы будут добавлены
     */
    public void treeElementsAdd() {
        Role role1 = new Role(Role.getNewId(), "qqq");
        Role role2 = new Role(Role.getNewId(), "www");
        Role role3 = new Role(Role.getNewId(), "eee");
        RoleStore roleStore = new RoleStore(2);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        assertThat(roleStore.toString(), is(role1.getId() + "-qqq " + role2.getId() + "-www " + role3.getId() + "-eee "));
    }
    @Test
    /**
     * если из массива, содержащего три элемента, удалить первый, два оставшихся буду сдвинуты в начало
     */
    public void firstElementDelete() {
        Role role1 = new Role(Role.getNewId(), "qqq");
        Role role2 = new Role(Role.getNewId(), "www");
        Role role3 = new Role(Role.getNewId(), "eee");
        RoleStore roleStore = new RoleStore(2);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.delete(role1.getId());
        assertThat(roleStore.toString(), is(role2.getId() + "-www " + role3.getId() + "-eee "));
    }
    @Test
    /**
     * в массиве, содержащем три элемента, обновляется второй
     */
    public void secondElementUpdate() {
        Role role1 = new Role(Role.getNewId(), "qqq");
        Role role2 = new Role(Role.getNewId(), "www");
        Role role3 = new Role(Role.getNewId(), "eee");
        RoleStore roleStore = new RoleStore(2);
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.update( new Role(role2.getId(), "rrr"));
        assertThat(roleStore.toString(), is(role1.getId() + "-qqq " + role2.getId() + "-rrr " + role3.getId() + "-eee "));
    }
}
