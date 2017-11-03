package ru.job4j.generic;

public interface Store <Base> {
    /**
     * метод добавляет объект model в структуру
     * @param model - model
     * @return model
     */
    Base add(Base model);

    /**
     * метод обновляет объект model в структуре
     * @param model - model
     * @return model
     */
    Base update(Base model);

    /**
     * метод удаляет объект из структуры
     * @param id - id объекта
     * @return true, если удаление произошло
     */
    boolean delete(String id);
}
