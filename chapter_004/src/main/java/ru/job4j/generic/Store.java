package ru.job4j.generic;

public interface Store <T extends  Base> {
    /**
     * метод добавляет объект model в структуру
     * @param model - model
     * @return model
     */
    T add(T model);

    /**
     * метод обновляет объект model в структуре
     * @param model - model
     * @return model
     */
    T update(T model);

    /**
     * метод удаляет объект из структуры
     * @param id - id объекта
     * @return true, если удаление произошло
     */
    boolean delete(String id);
}
