package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

/**
 * класс - хранилище пользователей
 */
@ThreadSafe
public class UserStorage {
    /**
     * список пользователей
     */
    @GuardedBy("this")
    private HashMap<Integer, User> userStorage = new HashMap<>();

    /**
     * метод добавляет пользователя в список
     * @param user - пользователь
     * @return true, если пользователь добавлен
     */
    public synchronized boolean add(User user) {
        return this.userStorage.put(user.getId(), user) != null;
    }

    /**
     * метод обновляет данные пользователя
     * @param user - пользователь
     * @return true, если данные обновлены
     */
    synchronized boolean update(User user) {
        boolean result = true;
        if (!this.userStorage.containsKey(user.getId())) {
            result = false;
        } else {
            this.userStorage.put(user.getId(), user);
        }
        return result;
    }

    /**
     * метод удаляет пользователя из списка
     * @param user - пользователь
     * @return true, если пользователь удален
     */
    public synchronized boolean delete(User user) {
        return this.userStorage.remove(user.getId(), user);
    }

    /**
     * метод перемещает деньги между счетами пользователей
     * @param fromId - id пользователя, счет которого уменьшается
     * @param toId - id пользователя, счет которого увеличивается
     * @param amount - сумма перевода
     * @return true, если перевод произведен
     */
    public synchronized boolean transfer(int fromId, int toId, int amount) {
       boolean result = true;
       if ((!this.userStorage.containsKey(fromId)) || (!this.userStorage.containsKey(toId)) || (this.userStorage.get(fromId).getAmount() < amount)) {
           result = false;
        } else {
           User userFrom = this.userStorage.get(fromId);
           User userTo = this.userStorage.get((toId));
           userFrom.setAmount(userFrom.getAmount() - amount);
           userTo.setAmount(userTo.getAmount() + amount);
           this.userStorage.put(userFrom.getId(), userFrom);
           this.userStorage.put(userTo.getId(), userTo);
        }
        return result;

    }

}
