package ru.job4j.generic;

/**
 * класс содержим методы, общие для списков объеков типа Base
 * @param <T>
 */
public abstract class AbstractStore<T extends Base> implements Store<T>  {
    /**
     * структура для хранения данных
     */
    SimpleArray<T> userArray;

    /**
     * конструктор.
     * @param size - начальное количество элементов
     */

    AbstractStore(int size) {
        this.userArray = new SimpleArray<T>(size);
    }

    /**
     * метод добавляет объект model в структуру.
     * @param model - model
     * @return model
     */

    public T add(T model) {
        this.userArray.add( model);
        return model;
    }

    /**
     * метод обновляет объект model в структуре.
     * @param model - model
     * @return model
     */

    public T update(T model) {
        T result = null;
        try {
            for (int i = 0; i < this.userArray.getLength(); i++) {
                if (this.userArray.get(i).getId().equals(model.getId())) {
                    this.userArray.update(i, model);
                    result = model;
                    break;
                }
            }
        } catch (OutOfSimpleArrayRangeException oosare) {

        }
        return result;
    }

    /**
     * метод удаляет объект с указанным id из структуры
     * @param id - id
     * @return true, если удаление произошло
     */

    public boolean delete(String id) {
        boolean result = false;
        try {
            for (int i = 0; i < this.userArray.getLength(); i++) {
                if (this.userArray.get(i).getId().equals(id)) {
                    this.userArray.delete(i);
                    result = true;
                    break;
                }
            }
        } catch (OutOfSimpleArrayRangeException oosare) {

        }
        return result;
    }

    /**
     * Метод переводит содержимое структуры в строку.
     * @return строка
     */
    public abstract String toString();
}

