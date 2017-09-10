package ru.job4j;
import java.util.Collection;
import java.util.Iterator;
/**
 * Class CollectionTesting реализкет методы для тестирования скорости работы коллекций.
 *
 * @author Tatyana Belova
 * @since 31.08.2017
 */
public class CollectionTesting {
    /**
     * метод вычисляет время в миллисекундах, необходимое для добавления amount строк, заполняемых случайными числами + номер строки.
     * @param collection - коллекция
     * @param amount - количество строк
     * @return время в миллисекундах
     */

    public long add(Collection<String> collection, int amount) {
        long begin = System.currentTimeMillis();
        for (int i = 1; i <= amount; i++){
            collection.add(Math.random() + " " + i);

        }
        return System.currentTimeMillis() - begin;

    }
    /**
     * метод вычисляет время в миллисекундах, необходимое для удаления всех строк из коллекции.
     * @param collection - коллекция
     * @return время в миллисекундах
     */
    public long delete(Collection<String> collection){
        long begin = System.currentTimeMillis();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        return System.currentTimeMillis() - begin;
    }

}
